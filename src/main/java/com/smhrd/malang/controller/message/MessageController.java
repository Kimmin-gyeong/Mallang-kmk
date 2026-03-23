package com.smhrd.malang.controller.message;

import com.smhrd.malang.dto.message.MessageSendRequestDto;
import com.smhrd.malang.dto.message.MessageSendResponseDto;
import com.smhrd.malang.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages") //url 주소 지음
@RequiredArgsConstructor //final 붙은 필드들을 자동으로 생성자 만들어주는 기능
public class MessageController {

    private final MessageService service;

    //1. 메시지 전송
    @PostMapping ("/send")//@RequestBody 사용자가 보낸 json데이터를 자바 객체로 자동 변환해주는 어노테이션
    public ResponseEntity<MessageSendResponseDto> sendMessage(@RequestBody MessageSendRequestDto requestDto) {
        MessageSendResponseDto responseDto = service.sendMessage(requestDto);
        return ResponseEntity.ok(responseDto);
    }////

}
