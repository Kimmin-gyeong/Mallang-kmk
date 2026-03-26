package com.smhrd.malang.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "locked_words",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "word"}))
public class LockedWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Integer wordId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "word", nullable = false, length = 50)
    private String word;

    // 등록 시간 (괸리용)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}