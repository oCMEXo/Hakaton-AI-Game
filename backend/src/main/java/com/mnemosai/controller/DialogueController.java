package com.mnemosai.controller;

import com.mnemosai.DialogueApi;
import com.mnemosai.model.dto.DialogueDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class DialogueController implements DialogueApi {
    @Override
    public List<DialogueDTO> getDialogs(Integer page, Integer size) {
        return DialogueApi.super.getDialogs(page, size);
    }

    @Override
    public DialogueDTO createDialog(String body) {
        return DialogueApi.super.createDialog(body);
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return DialogueApi.super.getRequest();
    }
}
