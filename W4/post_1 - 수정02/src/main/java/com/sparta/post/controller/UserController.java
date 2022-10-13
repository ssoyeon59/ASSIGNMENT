package com.sparta.post.controller;

import com.sparta.post.dto.UserRequestDto;
import com.sparta.post.dto.UserResponseDto;
import com.sparta.post.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    // 회원가입
    @PostMapping("/api/member/signup")
    public UserResponseDto signup(@RequestBody @Valid UserRequestDto userRequestDto) throws IllegalAccessException {
        return userService.registerUser(userRequestDto);
    }

    // 로그인
    @PostMapping("/api/member/login")
    public UserResponseDto login(@RequestBody UserRequestDto userRequestDto, HttpServletResponse httpServletResponse) {
        return userService.login(userRequestDto, httpServletResponse);
    }
}
