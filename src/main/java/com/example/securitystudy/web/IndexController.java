package com.example.securitystudy.web;

import com.example.securitystudy.dto.Member.MemberJoinRequestDto;
import com.example.securitystudy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String joinPage(){

        return "login/join";
    }

    @PostMapping("/login/join")
    public String userJoin(@ModelAttribute MemberJoinRequestDto requestDto) {

        memberService.addUser(requestDto);

        return "login/login";
    }

    @GetMapping("/admins")
    public String adminPage(){

        return "admin/admin";
    }

    @GetMapping("/posts")
    public String posts(@AuthenticationPrincipal UserDetails user, Model model){
        model.addAttribute("user",user.getUsername());
        return "post/post";
    }
}
