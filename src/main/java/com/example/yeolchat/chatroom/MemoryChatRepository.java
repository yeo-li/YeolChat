package com.example.yeolchat.chatroom;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryChatRepository {
    private final Map<Long, List<String>> chattings = new HashMap<>();

    public void createChatting(Long roomId) {
        chattings.put(roomId, new LinkedList<>());

    }

    public void removeChatting(Long roomId) {
        if(chattings.containsKey(roomId)){
            chattings.remove(roomId);
        } else{
            System.out.println("Chatting Room Not Found");
        }
    }

    public void saveChatting(Long roomId, String content) {
        List<String> chatting = chattings.get(roomId);
        chatting.add(content);
    }

    public List<String> returnAllChat(Long roomId) {
        return chattings.get(roomId);
    }
}
