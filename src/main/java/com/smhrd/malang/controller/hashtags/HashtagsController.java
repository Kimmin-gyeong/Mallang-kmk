package com.smhrd.malang.controller.hashtags;

import com.smhrd.malang.dto.personaTags.PersonaTagRequestDto;
import com.smhrd.malang.entity.Hashtags;
import com.smhrd.malang.repository.HashtagsRepository;
import com.smhrd.malang.service.hashtags.HashtagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HashtagsController {

    private final HashtagsService hashtagsService;

    public HashtagsController(HashtagsService hashtagsService){
        this.hashtagsService = hashtagsService;
    }

    // 해시태그 전체 리스트 불러오기
    @GetMapping("/hashtags/hashtag_list")
    public String hashList(Model model){
        List<Hashtags> list = hashtagsService.findAll();
        model.addAttribute("hashtags", list);
        return "hashtag_list";
    }

    // 새로운 해시태그등록 화면 불러오기
    @GetMapping("/hashtags/register")
    public String hashtagRegisterView() {
        return "hashtag_register_view";
    }

    // 해시태그 등록 하고 list 로 보냄
    @PostMapping("/hashtags/save")
    public String save(Hashtags hashtags, Model model){
        try{
            hashtagsService.saveHashtags(hashtags);
        } catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("hashtags", hashtagsService.findAll());
            return "hashtag_list";
        }
        return "redirect:/hashtag_list";
    }

    // 새로운 페르소나등록 화면 불러오기
    @GetMapping("/persona_tags/register")
    public String personaRegisterView(Model model) {
        List<Hashtags> list = hashtagsService.findAll();
        model.addAttribute("hashtags", list);
        return "persona_register_view";
    }

    // 태그 조합 저장
    @PostMapping("/persona_tags/create")
    public String createPersonaTags(PersonaTagRequestDto dto){

        // 체크 안 했을 경우
        if (dto.getHashtagIds() == null || dto.getHashtagIds().isEmpty()){
            return "redirect:/hashtags/register";
        }

        hashtagsService.savePersonaTags(dto);

        return "redirect:/hashtags/hashtag_list";
    }



    // 해시태그 삭제
    @PostMapping("/hashtags/delete")
    public String delete(Integer hashtagId){
        hashtagsService.delete(hashtagId);
        return "redirect:/hashtags/enroll";
    }
}
