package com.sparta.post.security;

import com.sparta.post.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig {

    private final JwtProvider jwtProvider ;

    public WebSecurityConfig(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        return (web) -> web.ignoring()
                .antMatchers("/h2-console/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        //회원가입 API
                        .antMatchers("/api/member/signup"
                        //로그인API
                        ,"/api/member/login"
                        //게시글목록조회API
                        ,"/api/post"
                        //게시글조회API
                        ,"/api/post/{id}"
                        //댓글목록조회API
                        ,"/api/comment/{id}").permitAll()
                        // 어떤 요청이든 '인증'
                        .anyRequest().authenticated()
                )
                // 로그인 기능 허용
                .formLogin()
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                //로그아웃 기능 허용
                .logout()
                .permitAll();

        return http.build();
    }
}
