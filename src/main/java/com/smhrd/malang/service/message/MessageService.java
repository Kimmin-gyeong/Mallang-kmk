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
        Message message = request.toEntity(); //사용자 입력 -> Entity로 벼환


        Message saved = repository.save(message);//DB에 저장

        return new MessageSendResponseDto(saved);//저장된 엔티티를 response dto로 반환

    }

}
