package com.smhrd.malang.controller.persona;

import com.smhrd.malang.dto.persona.PersonaCreateRequestDto;
import com.smhrd.malang.dto.persona.PersonaResponseDto;
import com.smhrd.malang.dto.persona.PersonaUpdateRequestDto;
import com.smhrd.malang.service.persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService service;

    //생성
    @PostMapping
    public ResponseEntity<PersonaResponseDto> create(@RequestBody PersonaCreateRequestDto dto){
        return ResponseEntity.status(201).body(service.createPersona(dto));
    }

    //전체조회
    @GetMapping
    public ResponseEntity<List<PersonaResponseDto>> getAll() {
        return ResponseEntity.ok(service.getPersonas());
    }

    //1개 조회
    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponseDto> getPersonaById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getPersonaById(id));
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<PersonaResponseDto> update(
            @PathVariable Integer id,
            @RequestBody PersonaUpdateRequestDto dto){
        return ResponseEntity.ok(service.updatePersona(id, dto));
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deletePersona(id);
        return ResponseEntity.ok().build();
    }
}
