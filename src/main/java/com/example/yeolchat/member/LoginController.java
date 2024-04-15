package com.example.yeolchat.member;

import com.example.yeolchat.member.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @PostMapping("/Login")
    public List<String> getUserChatRoom(@RequestBody String userName) { // 데이터 타입싱 안 맞으면 400 에러뜸
        loginService.join(userName);



        return "chatRoomList";
    }
}
