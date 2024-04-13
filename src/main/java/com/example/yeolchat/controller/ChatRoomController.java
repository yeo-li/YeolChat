package com.example.yeolchat.controller;


import com.example.yeolchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {

    @Autowired
    private final ChatService chatService = new ChatService();

    @GetMapping("/data")
    public String chatRoomPage() {
        return chatService.returnHTML();
    }
}