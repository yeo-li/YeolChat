package com.example.yeolchat.service;

import com.example.yeolchat.repository.MemoryChatMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private final MemoryChatMemoryRepository repository = new MemoryChatMemoryRepository();

    public void save(String data) {
        repository.save(data);
        return;
    }

    public String returnHTML() {
        String rst = "";
        System.out.println("chatMemoryRepository.returnAllChat() = " + repository.returnAllChat());
        for (String data : repository.returnAllChat()) {
            rst += "<p>"+data+"</p>";
        }

        return rst;
    }
}
