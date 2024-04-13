package com.example.yeolchat.controller;

import com.example.yeolchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    @Autowired private final ChatService chatService;

    @MessageMapping("/chat/send")
    public void sendMsg(@Payload String data) {
        chatService.save(data);
        simpMessagingTemplate.convertAndSend("/topic/roomId", data);
    }
}
