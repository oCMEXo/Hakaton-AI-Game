package com.mnemosai.controller;

import com.mnemosai.ContentApi;
import com.mnemosai.model.dto.ContentDTO;
import com.mnemosai.service.ContentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController implements ContentApi {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    public ContentDTO getContent(Integer headerId) {
        return contentService.getContent(headerId);
    }
}
