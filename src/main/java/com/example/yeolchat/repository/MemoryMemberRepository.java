package com.example.yeolchat.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.*;

@Repository
public class MemoryMemberRepository {
    private final List<String> members = new LinkedList<>();

    public void save(String userName) {
        members.add(userName);
    }

    public boolean isMember(String userName){
        return members.contains(userName);
    }


}
