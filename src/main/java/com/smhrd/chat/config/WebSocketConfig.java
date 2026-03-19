package com.smhrd.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // 설정 파일 역할을 한다 라고 지정
@EnableWebSocketMessageBroker // 메세지 브로커(구독관리, 엔드포인트 설정 등 담당) 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //
    // 메세지 브로커 정의 (구독관리에 대한 정의)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트가 채널 구독하는 주소
        registry.enableSimpleBroker("/topic");
        // 클라이언트가 서버로 메세지를 보낼 수 있는 주소
        registry.setApplicationDestinationPrefixes("/app");
    }

    // 엔드포인트 추가 설정 (클라이언트 -> 서버로 연결할 접점)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // /chat이라는 경로로 요청이 들어오면 클라이언트와 서버를 연결하는 작업 (CONNECT)
        registry.addEndpoint("/chat")
                .setAllowedOriginPatterns("*") // CORS(=다른 주소에서 요청하는 것을 막음)를 허용
                .withSockJS(); // Fallback 지원 (오래된 브라우저에서는 WebSocket이 지원되지 않을 수도 있어 연결이 끊어질 수 있음 -> 연결 유지를 도와주는 역할)
    }
}
