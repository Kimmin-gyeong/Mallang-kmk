package com.smhrd.malang.service.personaTags;

import com.smhrd.malang.entity.Persona_tags;
import com.smhrd.malang.entity.Personas;
import com.smhrd.malang.repository.PersonaTagsRepository;
import com.smhrd.malang.repository.PersonasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaTagsService {

    private final PersonaTagsRepository repository;
    private final PersonasRepository personasRepository;

    public  PersonaTagsService(PersonaTagsRepository repository, PersonasRepository personasRepository){
        this.repository = repository;
        this.personasRepository = personasRepository;
    }

    // 조회한 페르소나 조회
    public List<Persona_tags> findByPersonasPersonaId(Integer personaId){
        return repository.findByPersonasPersonaId(personaId);
    }

    // 모든 페르소나 조회
    public List<Personas> findAllPersonas(){
        return personasRepository.findAll();
    }

}
