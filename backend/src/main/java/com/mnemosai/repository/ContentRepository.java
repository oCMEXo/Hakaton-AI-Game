package com.mnemosai.repository;

import com.mnemosai.entity.ContentEntity;
import com.mnemosai.model.dto.ContentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
    ContentEntity findByHeader_Id(Long headerId);
}
