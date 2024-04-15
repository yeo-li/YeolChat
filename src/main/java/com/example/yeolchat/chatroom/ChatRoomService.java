package com.example.yeolchat.chatroom;

import com.example.yeolchat.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    @Autowired private final MemoryMemberRepository memberRepository;
    @Autowired private final MemoryChatRoomRepository chatRoomRepository;

    // 지금 로그인 한 사람의 정보를 어떻게 알지????

}
