package com.example.securitystudy.dto.Member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberJoinRequestDto {


    private String username;

    private String password;

    @Builder
    public MemberJoinRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*public Member toEntity(PasswordEncoder passwordEncoder){
        return Member.builder()
                .userId(username)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
    }*/
}
