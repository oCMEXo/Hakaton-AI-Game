package com.mnemosai.service;

import com.mnemosai.entity.DialogueEntity;
import com.mnemosai.model.dto.DialogueDTO;
import com.mnemosai.repository.DialogueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogueService {
    private final DialogueRepository dialogueRepository;
    private final GeminiProviderService geminiService;

    public DialogueService(DialogueRepository dialogueRepository,
                           GeminiProviderService geminiService) {
        this.dialogueRepository = dialogueRepository;
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
        DialogueEntity entity = new DialogueEntity();
        entity.setName(name);

        entity = dialogueRepository.save(entity);

        geminiService.sendRequest(String.format("I want to learn %s. You are an expert in this field." +
                "Create a bullet points list of the most important topics in order of studying them" +
                "with increasing complexity and difficulty." +
                "Provide an answer in English, without any additional details." +
                "Response should only contain a list.", name));

        DialogueDTO dto = new DialogueDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
