package com.mnemosai.repository;

import com.mnemosai.entity.DialogueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DialogueRepository extends JpaRepository<DialogueEntity, Long> {
}
