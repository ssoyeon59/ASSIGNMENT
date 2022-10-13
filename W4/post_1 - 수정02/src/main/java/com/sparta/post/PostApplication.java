package com.sparta.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(PostRepository postRepository) {
//        return (args) -> {
//            final var postRepository1 = postRepository;
//            postRepository1.save(new Post("1111", "22222", "3333", "1234"));
//        };
//    }
}
