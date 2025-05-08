package com.mnemosai.service;

import com.mnemosai.ContentApi;
import com.mnemosai.entity.ContentEntity;
import com.mnemosai.model.dto.ContentDTO;
import com.mnemosai.repository.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public ContentDTO getContent(Integer headerId) {
        ContentEntity entity = contentRepository.findByHeader_Id(headerId.longValue());
        ContentDTO dto = new ContentDTO();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setHeaderId(entity.getHeader().getId());
        return dto;
    }
}
