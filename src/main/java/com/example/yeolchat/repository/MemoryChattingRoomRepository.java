package com.example.yeolchat.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryChattingRoomRepository {
    private Map<Long, LinkedList<String>> chattingRooms = new HashMap<>();
    private Long RoomId = 0L;

    public void createChattingRoom(String userName) {
        LinkedList<String> subscribers = new LinkedList<>();
        subscribers.add(userName);

        chattingRooms.put(RoomId, subscribers);
        RoomId++;
    }

    public void addSubscriber(Long roomId, String userName) {

        if(!chattingRooms.containsKey(roomId)){
            System.out.println("Chatting Room Not Found!");
            return; // 에러 throw
        }

        List<String> subscribers = chattingRooms.get(roomId);
        if(!subscribers.contains(userName)) {
            subscribers.add(userName); // 참여자 추가
        }
    }

    public void removeSubscriber(Long roomId, String userName) {

        if(!chattingRooms.containsKey(roomId)){
            System.out.println("Chatting Room Not Found!");
            return; // 에러 throw
        }

        List<String> subscribers = chattingRooms.get(roomId);
        if(!subscribers.contains(userName)) {
            subscribers.remove(userName); // 참여자 삭제
        }
    }

    public List<String> getChattingInRoomId(Long roomId) {
        return chattingRooms.get(roomId);
    }

    public void removeChattingRoom(Long roomId) {
        chattingRooms.remove(roomId);
    }
}
