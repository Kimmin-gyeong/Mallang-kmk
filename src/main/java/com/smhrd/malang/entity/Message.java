package com.smhrd.malang.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity(name="chat_messages")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 자동생성
    @Column(name="msg_id", updatable = false)
    private Long msgId; // BIGINT, PK, 자동생성

    @Column(name="room_id")
    private Integer roomId;

    @Column(name="sender_id")
    private Integer senderId;

    @Column(name = "persona_id")
    private Integer personaId;


    @Column(name = "original_msg", nullable = false)
    private String originalMsg;

    @Column(name = "corrected_msg")
    private String correctedMsg;

    @Column(name = "final_msg", nullable = false)
    private String finalMsg; //전송할 메시지

    @Column(name = "explanation")
    private String explanation;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt; //메시지를 보낸 시간(자동)

}
