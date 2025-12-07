package com.io.ted.repository;

import com.io.ted.model.TedTalk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TedTalkRepository extends JpaRepository<TedTalk, Long> {}
