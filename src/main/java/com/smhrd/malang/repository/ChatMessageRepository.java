package com.smhrd.malang.repository;

import com.smhrd.malang.domain.ChatMessage;
import com.smhrd.malang.domain.LockedWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
