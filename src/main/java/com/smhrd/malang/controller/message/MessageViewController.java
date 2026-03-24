package com.smhrd.malang.controller.message;

import com.smhrd.malang.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageViewController {

    @GetMapping("/send")
    public String sendPage(Model model){
        model.addAttribute("message", new Message());
        return "send"; //send.html반환
    }

}
