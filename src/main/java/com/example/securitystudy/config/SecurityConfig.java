package com.example.securitystudy.config;

import com.example.securitystudy.domain.member.Role;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable().headers().frameOptions().disable().and() //h2-console 화면을 사용하기 위해 해당 옵션들을 disable 합니다.
                .authorizeHttpRequests()
                .requestMatchers("/", "/user/**", "/login-proc").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()    // 추가
                .requestMatchers("/ledgers/**", "/api/v1/**").hasRole(Role.USER.name())
                .requestMatchers("/admins/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/login-proc")
                .defaultSuccessUrl("/ledgers", true)
                .and()
                .logout()
                .logoutSuccessUrl("/");

        return http.build();
    }

}
