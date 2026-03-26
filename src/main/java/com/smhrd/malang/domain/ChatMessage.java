package com.smhrd.malang.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
@Getter @Setter
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "msg_id")
    private Long msgId;

    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "original_msg", columnDefinition = "TEXT")
    private String originalMsg;

    @Column(name = "corrected_msg", columnDefinition = "TEXT")
    private String correctedMsg;

    @Column(name = "final_msg", columnDefinition = "TEXT")
    private String finalMsg;

    @Column(name = "explanation", columnDefinition = "TEXT")
    private String explanation;

    @Column(name = "persona_id")
    private Integer personaId;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}