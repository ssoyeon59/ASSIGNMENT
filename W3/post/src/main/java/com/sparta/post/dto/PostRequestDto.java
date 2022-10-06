package com.sparta.post.dto;

import com.sparta.post.entity.Timestamped;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class PostRequestDto extends Timestamped {

    //private 필수적으로 받아야 하는 정보 title, writer, content
    private final String title;
    private final String writer;
    private final String content;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public PostRequestDto() {
        this.title = getTitle();
        this.writer = getWriter();
        this.content = getContent();
        this.password = getPassword();
        this.createdAt = getCreatedAt();
        this.modifiedAt = getModifiedAt();
    }
}



