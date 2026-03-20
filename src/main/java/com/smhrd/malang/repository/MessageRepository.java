package com.smhrd.malang.repository;

import com.smhrd.malang.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
// Message 테이블을 관리하는 Repository, pk타입(식별자) = Long
}
