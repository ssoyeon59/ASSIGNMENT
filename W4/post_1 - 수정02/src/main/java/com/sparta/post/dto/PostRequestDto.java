package com.sparta.post.dto;

import com.sparta.post.entity.Timestamped;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Getter
@RequiredArgsConstructor
public class PostRequestDto extends Timestamped {
    //private 필수적으로 받아야 하는 정보 title, writer, content
    private final String title;
    private final String author;
    private final String content;
    private final String password;

    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public PostRequestDto() {
        this.title = getTitle();
        this.author = getAuthor();
        this.content = getContent();
        this.password = getPassword();
        this.createdAt = getCreatedAt();
        this.modifiedAt = getModifiedAt();
    }

    public String getContents() {
        return content;
    }
}



