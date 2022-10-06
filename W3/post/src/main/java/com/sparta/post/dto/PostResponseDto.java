package com.sparta.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PostResponseDto {
    private  String title;
    private  String writer;
    private  String createdAt;
    private  String modifiedAt;

}
