package com.smhrd.malang.controller.persona;

import com.smhrd.malang.dto.persona.PersonaCreateRequestDto;
import com.smhrd.malang.dto.persona.PersonaUpdateRequestDto;
import com.smhrd.malang.service.persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaViewController {

    private final PersonaService service;

    //페르소나 전체 조회
    @GetMapping
    public String list(Model model){
        model.addAttribute("personas", service.getPersonas());
        return "persona/list"; //해당 페이지 return
    }
    //페르소나 생성페이지 이동
    @GetMapping("/create")
    public String createForm(){
        return "persona/create";
    }
    // 페르소나 생성처리
    @PostMapping("/create")
    public String create(PersonaCreateRequestDto dto){
        service.createPersona(dto);
        return "redirect:/personas";
    }
    //페르소나 수정
    @GetMapping("edit/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        model.addAttribute("persona", service.getPersonaById(id));
        return "persona/edit";
    }
    //페르소나 수정 처리
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, PersonaUpdateRequestDto dto){
        service.updatePersona(id,dto);
        return "redirect:/personas";
    }
    //페르소나 삭제
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.deletePersona(id);
        return "redirect:/personas";
    }
}
