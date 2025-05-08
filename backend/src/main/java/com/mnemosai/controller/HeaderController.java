package com.mnemosai.controller;

import com.mnemosai.HeaderApi;
import com.mnemosai.model.dto.HeaderDTO;
import com.mnemosai.service.HeaderService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeaderController implements HeaderApi {
    private final HeaderService headerService;

    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @Override
    public List<HeaderDTO> getHeaders(Integer dialogueId) {
        return headerService.getHeaders(dialogueId);
    }
}
