package com.sparta.post.dto;

import com.sparta.post.entity.User;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long postId;
    private String comment;
    private User user;
}
