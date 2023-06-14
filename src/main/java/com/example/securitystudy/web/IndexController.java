package com.example.securitystudy.web;

import com.example.securitystudy.dto.Member.MemberJoinRequestDto;
import com.example.securitystudy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/login/login")
    public String loginPage(){

        return "login/login";
    }

    @GetMapping("/login/join")
    public String join(){

        return "login/join";
    }

    @PostMapping("/login/join")
    public String userJoin(@ModelAttribute MemberJoinRequestDto requestDto) {

        //memberService.addUser(requestDto);

        return "user/login";
    }

    @GetMapping("/admins")
    public String adminPage(){

        return "admin/admin";
    }

    @GetMapping("/posts")
    public String ledgers(){


        return "post/post";
    }
}