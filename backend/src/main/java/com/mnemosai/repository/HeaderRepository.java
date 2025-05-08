package com.mnemosai.repository;

import com.mnemosai.entity.HeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderRepository extends JpaRepository<HeaderEntity, Long> {
}
