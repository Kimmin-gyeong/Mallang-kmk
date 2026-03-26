package com.smhrd.malang.service.persona;

import com.smhrd.malang.dto.persona.PersonaCreateRequestDto;
import com.smhrd.malang.dto.persona.PersonaResponseDto;
import com.smhrd.malang.dto.persona.PersonaUpdateRequestDto;
import com.smhrd.malang.domain.Persona;
import com.smhrd.malang.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository repository; //페르소나리포지터리를 사용해서 db작업을 한다
    // jpa(repository가) db에서 데이터를 조회하고 그 결과를 객체로 만들어서 service에 반환함.

    //생성 : 사용자가 보낸 페르소나 정보를 받아서 DB에 저장하고, 저장된 결과를 정리해서 다시 사용자에게 알려주는 메서드
    public PersonaResponseDto createPersona(PersonaCreateRequestDto dto){
        Persona persona = dto.toEntity();
        Persona saved = repository.save(persona);
        return new PersonaResponseDto(saved);
    }

    //전체조회 : 사용자가 만들어진 페르소나 뭐있는지 봐야함 //
    public List<PersonaResponseDto> getPersonas(){
        return repository.findAll()
                .stream() //하나씩 꺼내서 처리
                .map(PersonaResponseDto::new) // 페르소나 -> dto변환
                .toList();//리스트로 변환
    }

    //페르소나 1개 조회 (뷰 컨트롤러에서 수정edit페이지 렌더링할때 필요함) 특정 id의 페르소나 정보를 가져오는 기능
    public PersonaResponseDto getPersonaById(Integer id){
        Persona persona = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 페르소나 없음"));
        return new PersonaResponseDto(persona);
    }

    //수정
    public PersonaResponseDto updatePersona(Integer id, PersonaUpdateRequestDto dto){
        Persona persona = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 페르소나 없음"));

        persona.setPersonaName(dto.getPersonaName());

        Persona updated = repository.save(persona);
        return new PersonaResponseDto(updated);
    }

    //삭제
    public void deletePersona(Integer id){//id로 삭제할 페르소나 조회
        repository.deleteById(id);
    }
}
