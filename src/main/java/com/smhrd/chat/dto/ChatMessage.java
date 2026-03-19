package com.smhrd.chat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ChatMessage {
   private String sender;
   private String message;
}
