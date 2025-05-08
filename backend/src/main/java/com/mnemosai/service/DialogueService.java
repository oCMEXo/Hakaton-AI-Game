package com.mnemosai.service;

import com.mnemosai.entity.ContentEntity;
import com.mnemosai.entity.DialogueEntity;
import com.mnemosai.entity.HeaderEntity;
import com.mnemosai.model.dto.DialogueDTO;
import com.mnemosai.repository.ContentRepository;
import com.mnemosai.repository.DialogueRepository;
import com.mnemosai.repository.HeaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Service
public class DialogueService {
    private final DialogueRepository dialogueRepository;
    private final HeaderRepository headerRepository;
    private final ContentRepository contentRepository;
    private final GeminiProviderService geminiService;

    public DialogueService(DialogueRepository dialogueRepository,
                           HeaderRepository headerRepository,
                           ContentRepository contentRepository,
                           GeminiProviderService geminiService) {
        this.dialogueRepository = dialogueRepository;
        this.headerRepository = headerRepository;
        this.contentRepository = contentRepository;
        this.geminiService = geminiService;
    }

    public List<DialogueDTO> getDialogs(Integer page, Integer size) {
        List<DialogueEntity> dialogs = dialogueRepository.findAll();

        return dialogs.stream()
                .map(entity -> {
                    DialogueDTO dto = new DialogueDTO();
                    dto.setId(entity.getId());
                    dto.setName(entity.getName());
                    return dto;
                })
                .toList();
    }

    public DialogueDTO createDialog(String name) {
        DialogueEntity dialogueEntity = new DialogueEntity();
        dialogueEntity.setName(name);
        final DialogueEntity writtenDialogueEntity = dialogueRepository.saveAndFlush(dialogueEntity);

        String headersRaw = geminiService.sendRequest(
                "I want to learn %s. You are an expert in this field. ".formatted(name) +
                        "Create a bullet points list of the most important topics in order of studying them " +
                        "with increasing complexity and difficulty. Provide an answer in English, without any additional details. " +
                        "Response should only contain a list."
        );

        List<String> headerTitles = Arrays.stream(headersRaw.split("\\*"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        List<CompletableFuture<Void>> futures = IntStream.range(0, headerTitles.size())
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    // Создание header
                    HeaderEntity header = new HeaderEntity();
                    header.setDialogue(writtenDialogueEntity);
                    header.setTitle(headerTitles.get(i));
                    header.setNumber(i);
                    HeaderEntity savedHeader = headerRepository.save(header);

                    String contentRaw = geminiService.sendRequest(
                            "I want to learn subtopic %s of topic %s. ".formatted(savedHeader.getTitle(), name) +
                                    "You are an expert in this field. Create a wide and easy-to-use summary for me to study the topic. " +
                                    "Response must be providen in plain-text format. " +
                                    "You are advised to add links to popular study materials about this subtopic."
                    );

                    ContentEntity content = new ContentEntity();
                    content.setHeader(savedHeader);
                    content.setContent(contentRaw);
                    contentRepository.save(content);
                })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        DialogueDTO dto = new DialogueDTO();
        dto.setId(dialogueEntity.getId());
        dto.setName(dialogueEntity.getName());
        return dto;
    }
}
