package com.mnemosai.repository;

import com.mnemosai.entity.HeaderEntity;
import com.mnemosai.model.dto.HeaderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaderRepository extends JpaRepository<HeaderEntity, Long> {
    List<HeaderEntity> findAllByDialogue_Id(Long dialogueId);
}
