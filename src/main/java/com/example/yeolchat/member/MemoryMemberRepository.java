package com.example.yeolchat.member;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.*;

@Repository
public class MemoryMemberRepository {
    private final List<String> members = new LinkedList<>();

    public void saveMember(String userName) {
        members.add(userName);
    }

    public void removeMember(String userName) {
        members.remove(userName);
    }

    public List<String> getMembers() {
        return members;
    }
}
