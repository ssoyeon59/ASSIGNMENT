package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//@Getter
@Setter
//@Builder
//public class PostResponseDto {
//    private String title;
//    private String author;
//    private String createAt;
//}

@Getter
public class PostResponseDto {
    private String title;
    private String contents;

    private Long id;
    private String author;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto (Post post){
        this.title = post.getTitle();
        this.contents = post.getContents();

        this.id = post.getId();
        this.author = post.getUser().getUsername();
        this.createAt = post.getCreateAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
