package com.smhrd.chat.controller;


import com.smhrd.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }

    @MessageMapping("/sendMessage") // 클라이언트가 메시지를 이곳으로 보내면 메서드를 실행
    @SendTo("/topic/messages") // 처리된 결과를 구독(/topic/messages)한 모든 클라이언트에게 전달
    public ChatMessage sendMessage(ChatMessage message){
        // 다른 클라이언트에게 전달  // 입력 받은 채팅 메시지
        return message;
    }
}
