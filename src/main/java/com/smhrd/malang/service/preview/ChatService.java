package com.smhrd.malang.service.preview;

import com.smhrd.malang.dto.preview.ChatRequest;
import com.smhrd.malang.entity.ChatMessage;
import com.smhrd.malang.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatService(ChatMessageRepository chatMessageRepository){
        this.chatMessageRepository = chatMessageRepository;
    }

    // 임시
    public ChatMessage createCorrection(ChatRequest request) {
        ChatMessage msg = new ChatMessage();
        msg.setRoomId(1); // 테스트용 임시값
        msg.setSenderId(1); // 테스트용 임시값
//        msg.setPersonaId(1); // 테스트용 임시값
        msg.setOriginalMsg(request.getOriginalMsg());

        msg.setFinalMsg("");

        return chatMessageRepository.save(msg);
    }
}