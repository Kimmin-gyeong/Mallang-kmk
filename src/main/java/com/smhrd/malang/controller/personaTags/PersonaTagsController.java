package com.smhrd.malang.controller.personaTags;

import com.smhrd.malang.entity.Persona_tags;
import com.smhrd.malang.service.personaTags.PersonaTagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonaTagsController {

    private final PersonaTagsService service;

    public PersonaTagsController(PersonaTagsService service) {
        this.service = service;
    }

    // 처음 페이지
    @GetMapping("/persona_tags/view")
    public String personaTagsMain(Model model){
        model.addAttribute("personas", service.findAllPersonas());
        return "personaTagsView";
    }

    // 페르소나에 맞는 해시태그 조회
    @PostMapping ("/persona_tags/search")
    public String showPersonaTags(@RequestParam("personaId") Integer personaId, Model model){

        // 입력받은 ID로 persona_tags 테이블 조회
        List<Persona_tags> list = service.findByPersonasPersonaId(personaId);

        // 결과 리스트 전달
        model.addAttribute("personaTags", list);

        // 검색 결과
        model.addAttribute("searchedId", personaId);

        return "personaTagsView";
    }
    // 페르소나 삭제시 페르소나에 등록된 해시태그 같이 삭제

    // 해시태그 중복 선택 불가

    // + 해시태그들 등록
}
