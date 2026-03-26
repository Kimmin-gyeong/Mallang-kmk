package com.smhrd.malang.service.preview;

import com.smhrd.malang.dto.preview.ChatRequest;
<<<<<<< HEAD
import com.smhrd.malang.entity.ChatMessage;
import com.smhrd.malang.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

=======
import com.smhrd.malang.domain.ChatMessage;
import com.smhrd.malang.repository.ChatMessageRepository;
import com.smhrd.malang.repository.LockedWordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

>>>>>>> malangTeam/malang-y
@Service
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
<<<<<<< HEAD

    public ChatService(ChatMessageRepository chatMessageRepository){
        this.chatMessageRepository = chatMessageRepository;
    }

    // 임시
    public ChatMessage createCorrection(ChatRequest request) {
=======
    private final LockedWordRepository lockedWordRepository; //단어보호정보를 담기위해 연결

    public ChatService(ChatMessageRepository chatMessageRepository, LockedWordRepository lockedWordRepository){
        this.chatMessageRepository = chatMessageRepository;
        this.lockedWordRepository = lockedWordRepository;
    }

    // 임시 : 보정 요청 기능
    public ChatMessage createCorrection(ChatRequest request) {

>>>>>>> malangTeam/malang-y
        ChatMessage msg = new ChatMessage();
        msg.setRoomId(1); // 테스트용 임시값
        msg.setSenderId(1); // 테스트용 임시값
//        msg.setPersonaId(1); // 테스트용 임시값
        msg.setOriginalMsg(request.getOriginalMsg());
<<<<<<< HEAD

=======
>>>>>>> malangTeam/malang-y
        msg.setFinalMsg("");

        return chatMessageRepository.save(msg);
    }
<<<<<<< HEAD
=======

>>>>>>> malangTeam/malang-y
}