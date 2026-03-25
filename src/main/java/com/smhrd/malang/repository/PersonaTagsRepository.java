package com.smhrd.malang.repository;

import com.smhrd.malang.entity.Persona_tags;
import com.smhrd.malang.service.personaTags.PersonaTagsService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaTagsRepository extends JpaRepository<Persona_tags, Integer> {
    List<Persona_tags> findByPersonasPersonaId(Integer personaId);
    // 데이터베이스에서 personaId로 페르소나 태그 리스트를 조회
}
