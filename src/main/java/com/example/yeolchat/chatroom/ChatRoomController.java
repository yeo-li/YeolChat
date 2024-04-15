package com.example.yeolchat.chatroom;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {

    @Autowired private final ChatService chatService;

    @GetMapping("/data")
    public String chatRoomPage() {
        return chatService.returnHTML();
    }
}