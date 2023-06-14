package com.example.securitystudy.service.member;

import com.example.securitystudy.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    //private final PasswordEncoder passwordEncoder;

    public boolean existsByUserId(String username) throws Exception{
        boolean flag = memberRepository.existsByUserId(username);
        System.out.println("flag :::" + flag);

        if(flag == true){
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
        return flag;
    }

    /*
    public String addUser(MemberJoinRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity(passwordEncoder)).getUserId();
    }

     */
}
