package com.sparta.post;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import com.sparta.post.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PostRepository postRepository, PostService postService) {
        return (args) -> {
//            postRepository.save(new Post("프론트엔드의 꽃, 리액트","김철수", "첫게시물","1123"));
//
//            System.out.println("데이터 인쇄");
//            List<Post> postList = postRepository.findAll();
//            for (int i=0; i<postList.size(); i++) {
//                Post post = postList.get(i);
//                System.out.println(post.getId());
//                System.out.println(post.getTitle());
//                System.out.println(post.getWriter());
//                System.out.println(post.getContent());
//                System.out.println(post.getPassword());
//                System.out.println(post.getCreatedAt());
//            }
//
//            PostRequestDto new_post = new PostRequestDto("웹개발의 봄, Spring", "김철수", "첫 게시물?","1123");
//            postService.update(1L, new_post);
//            postList = postRepository.findAll();
//            for (int i=0; i<postList.size(); i++) {
//                Post post = postList.get(i);
//                System.out.println(post.getId());
//                System.out.println(post.getTitle());
//                System.out.println(post.getWriter());
//                System.out.println(post.getContent());
//                System.out.println(post.getPassword());
//                System.out.println(post.getCreatedAt());
//            }

        };
    }
}
