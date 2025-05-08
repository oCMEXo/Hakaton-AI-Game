package com.mnemosai.controller;

import com.mnemosai.ContentApi;
import com.mnemosai.model.dto.ContentDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController implements ContentApi {
    @Override
    public ContentDTO getContent(Integer headerId) {
        return ContentApi.super.getContent(headerId);
    }
}
