package com.smhrd.malang.controller.preview;

import com.smhrd.malang.domain.ChatMessage;
import com.smhrd.malang.domain.LockedWord;
import com.smhrd.malang.dto.preview.ChatRequest;
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

    @GetMapping("/chat")
    public String chatPage() {
        return "preview/chatView";
    }

    @PostMapping("/chat/correct")
    public String correct(ChatRequest request, Model model) {
        ChatMessage result = chatService.createCorrection(request);
        model.addAttribute("result",result);
        return "preview/chatView";
    }
}
