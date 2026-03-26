package com.smhrd.malang.service.message;

import com.smhrd.malang.dto.message.MessageSendRequestDto;
import com.smhrd.malang.dto.message.MessageSendResponseDto;
import com.smhrd.malang.domain.Message;
import com.smhrd.malang.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository repository;


    //메시지 전송
    public MessageSendResponseDto sendMessage(MessageSendRequestDto request){
        Message message = request.toEntity(); //사용자 입력 -> Entity로 변환
        Message saved = repository.save(message);//DB에 저장
        return new MessageSendResponseDto(saved);//저장된 엔티티를 response dto로 반환

        //1. senderId를 userId처럼 사용 (단어잠금 기능 사용하기 위해)
        //Integer userId = request.getSenderId();

        //2. 이 유저(senderId)의 잠금 단어 조회

    }

}
