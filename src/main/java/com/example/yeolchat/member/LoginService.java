package com.example.yeolchat.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    @Autowired private final MemoryMemberRepository memberRepository;

    public void join(String userName) {
        if(!confirmLogin(userName)){
            memberRepository.saveMember(userName);
        }
    }

    public boolean confirmLogin(String userName) {
        if(memberRepository.getMembers().contains(userName)){
            return true;
        } else {
            return false;
        }
    }
}
