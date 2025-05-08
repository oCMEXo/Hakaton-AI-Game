package com.mnemosai.controller;

import com.mnemosai.DialogueApi;
import com.mnemosai.model.dto.DialogueDTO;
import com.mnemosai.service.DialogueService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DialogueController implements DialogueApi {
    private final DialogueService dialogueService;

    public DialogueController(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }

    @Override
    public List<DialogueDTO> getDialogs(Integer page, Integer size) {
        return dialogueService.getDialogs(page, size);
    }

    @Override
    public DialogueDTO createDialog(String name) {
        return dialogueService.createDialog(name);
    }
}
