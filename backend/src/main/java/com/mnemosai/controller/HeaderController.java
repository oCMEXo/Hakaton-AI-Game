package com.mnemosai.controller;

import com.mnemosai.HeaderApi;
import com.mnemosai.model.dto.HeaderDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeaderController implements HeaderApi {
    @Override
    public List<HeaderDTO> getHeaders(Integer dialogueId) {
        return HeaderApi.super.getHeaders(dialogueId);
    }
}
