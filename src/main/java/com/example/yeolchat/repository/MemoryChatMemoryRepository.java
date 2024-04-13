package com.example.yeolchat.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class MemoryChatMemoryRepository {
    private final List<String> contents = new LinkedList<>();

    public void save(String data) {
        contents.add(data);
    }

    public List<String> returnAllChat() {
        return contents;
    }
}
