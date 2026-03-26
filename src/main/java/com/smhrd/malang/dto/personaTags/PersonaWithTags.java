package com.smhrd.malang.dto.personaTags;

import com.smhrd.malang.entity.Persona_tags;
import com.smhrd.malang.entity.Personas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonaWithTags {

    private Personas personas;
    private List<Persona_tags> tags;
}
