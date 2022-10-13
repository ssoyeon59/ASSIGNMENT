package com.sparta.post.controller;

import com.sparta.post.dto.PostListResponseDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.security.UserDetaiImp;
import com.sparta.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 글 작성
    @PostMapping("/api/auth/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetaiImp userDetailImp) {
        return postService.createPost(postRequestDto, userDetailImp.getUsername());
    }

    // 글 전체 목록 보기
    @GetMapping("/api/post")
    public List<PostListResponseDto> getPostAll() {
        return postService.getPostAll();
    }

    // 글 상세보기
    @GetMapping("/api/post/{id}")
    public PostResponseDto getPostDetail(@PathVariable Long id) {
        return postService.getPostDetail(id);
    }

    // 글 수정
    @PutMapping("/api/auth/post/{id}")
    public PostResponseDto updataPost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetaiImp userDetailImp) {
        return postService.updatePost(id, postRequestDto, userDetailImp.getUsername());
    }

    // 글 삭제
    @DeleteMapping("/api/auth/post/{id}")
    public String deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetaiImp userDetailImp) {
        return postService.deletePost(id, userDetailImp.getUsername());
    }
}
