package com.mnemosai.service;

import com.mnemosai.entity.HeaderEntity;
import com.mnemosai.model.dto.HeaderDTO;
import com.mnemosai.repository.HeaderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeaderService {
    private final HeaderRepository headerRepository;

    public HeaderService(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    public List<HeaderDTO> getHeaders(Integer dialogueId) {
        return headerRepository.findAllByDialogue_Id(dialogueId.longValue()).stream()
                .map(entity -> {
                    HeaderDTO dto = new HeaderDTO();
                    dto.setId(entity.getId());
                    dto.setDialogueId(entity.getDialogue().getId());
                    dto.setTitle(entity.getTitle());
                    dto.setOrderNumber(entity.getNumber());
                    return dto;
                })
                .toList();
    }
}
