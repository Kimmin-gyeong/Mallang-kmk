package com.smhrd.malang.controller.preview;

import com.smhrd.malang.dto.preview.ChatRequest;
import com.smhrd.malang.entity.ChatMessage;
import com.smhrd.malang.repository.ChatMessageRepository;
import com.smhrd.malang.service.preview.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ChatController {
    private final ChatService chatService;
    private final ChatMessageRepository chatMessageRepository;

    public ChatController(ChatService chatService, ChatMessageRepository chatMessageRepository) {
        this.chatService = chatService;
        this.chatMessageRepository = chatMessageRepository;
    }

    // 시작 화면
    @GetMapping("/chat")
    public String chatPage() {
        return "chatView";
    }

    @PostMapping("/chat/correct")
    public String correct(ChatRequest request, Model model) {
        ChatMessage result = chatService.createCorrection(request);
        model.addAttribute("result",result);
        return "chatView";
    }
}
