package com.smhrd.malang.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Integer personaId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "persona_name", nullable = false)
    private String personaName;

    @Column(name = "system_prompt", nullable = false)
    private String systemPrompt;

}

// personas가 없어서 임의로 만듦