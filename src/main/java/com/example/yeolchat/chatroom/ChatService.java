package com.example.yeolchat.chatroom;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // todo 이게 뭔데;;
public class ChatService {

    @Autowired
    private final MemoryChatRepository chatRepository;

    public void save(String data) {
        chatRepository.save(data);
    }

    public String returnHTML() {
        String rst = "";
        System.out.println("chatMemoryRepository.returnAllChat() = " + chatRepository.returnAllChat());
        for (String data : chatRepository.returnAllChat()) {
            rst += "<p>"+data+"</p>";
        }

        return rst;
    }
}
