package com.smhrd.malang.dto.message;

import com.smhrd.malang.domain.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MessageSendRequestDto {

    private Integer roomId;
    private Integer senderId;
    private Integer personaId;
    private String originalMsg;
    private String correctedMsg;
    private String finalMsg;
    private String explanation;

    // DTO → Entity 변환
    public Message toEntity() {
        return Message.builder()
                .roomId(roomId)
                .senderId(senderId)
                .personaId(personaId)
                .originalMsg(originalMsg)
                .correctedMsg(correctedMsg)
                .finalMsg(finalMsg)
                .explanation(explanation)
                .build();
    }
}
