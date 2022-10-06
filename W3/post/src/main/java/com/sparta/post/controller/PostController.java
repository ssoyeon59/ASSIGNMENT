package com.sparta.post.controller;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import com.sparta.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    //전체 게시글 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> getPost() { //list의 형태를 보여준다.
        //PostResponseDto의 리스트의 allPost이 postService.findAllPost()메서드의 값이다
        List<PostResponseDto> allPost = postService.findAllPost();
        return allPost;
    }

    //게시글 작성,같은 주소라도 방식(Post타입)이 다름을 구분
    @PostMapping("/api/posts")
    //requestDto는 생성요청의 의미
    //@RequestBody로 정보를 보내겠다.
    public Post creatPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto); //post를 객체화 시켜준다
        //JPA를 이용하여 DB에 저장, 그 결과 반환
        return postRepository.save(post);
    }

    //게시글 상세 조회
    @GetMapping("/api/posts/{id}")
    public Post getDetailPost(@PathVariable Long id) {
        //post에 찾는 id가 없다면 "해당게시물이 존재하지 않습니다"라고 띄워준다
        Post post = postRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return post;
    }

    //비밀번호 확인
    @PostMapping("/api/posts/{id}")
    public boolean comparePassword(@PathVariable Long id, @RequestBody PostRequestDto postPasswordDto) { //비밀번호 받는 것 : 파람이나 바디
        // 포스트서비스에 비밀번호 일치여부를 판단하는 메서드에 아이디와 비밀번호를 넘겨준다
        return postService.comparePassword(id, postPasswordDto);
    }
    //게시글 수정
    @PutMapping("/api/posts/{id}")
    //아이디 정보와, RequestDto에서 받은 body 정보를 가져온다
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
//        return postService.delete(id);
        return id;
    }
}
