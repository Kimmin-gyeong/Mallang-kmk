package com.smhrd.malang.dto.message;

import com.smhrd.malang.entity.Message;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
public class MessageSendResponseDto { //응답용 dto(서버->사용자)

    private String finalMsg;

    //파이널 메시지만 생성자로 초기화
    public MessageSendResponseDto(Message message){
        this.finalMsg = message.getFinalMsg();
    }

}
