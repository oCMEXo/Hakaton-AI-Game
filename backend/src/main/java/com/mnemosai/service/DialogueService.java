package com.mnemosai.service;

import com.mnemosai.entity.DialogueEntity;
import com.mnemosai.model.dto.DialogueDTO;
import com.mnemosai.repository.DialogueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogueService {
    private final DialogueRepository dialogueRepository;

    public DialogueService(DialogueRepository dialogueRepository) {
        this.dialogueRepository = dialogueRepository;
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

        DialogueDTO dto = new DialogueDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
