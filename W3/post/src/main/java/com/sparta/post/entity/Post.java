package com.sparta.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.post.dto.PostRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor //기본생성자를 만듭니다
@Entity
public class Post extends Timestamped {
//    @JsonIgnore //필드 레벨에서 무시될 수 있는 속성을 표시한다
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id //해당 프로퍼티가 테이블의 주키 역할을 한다는 것을 나타낸다. 실행시점에 객체의 필드를 통해 직접 접근하게 한다.
    private Long id;

    //제목 필드 선언 String 타입으로 private접근제한을 갖는다
    @Column(nullable = false) //객체필드를 테이블의 컬럼에 매핑시켜주는 어노테이션이다. null값을 사용할 수 없다는 조건이 있다.
    private String title;

    //작성자를 String 타입으로 private접근제한을 갖는다
    @Column(nullable = false)
    private String writer;

    //작성 내용을 String 타입으로 private접근제한을 갖는다
    @Column(nullable = false)
    private String content;

    @JsonIgnore //필드 레벨에서 무시될 수 있는 속성을 표시한다
    @Column(nullable = false)
    private String password;

    //Post를 public 접근 제한자로 선언한다. //위에 NoArgsConstructor이 있으면 기본생성자를 쓸 필요가 없다
//    public Post(String title, String writer, String content, String password) {
//        this.title = title;
//        this.writer = writer;
//        this.content = content;
//        this.password = password;
//    }

    public Long getId() { return id; }

    public String getTitle() { return this.title; }

    public String getWriter() { return  this.writer; }

    public String getContent() { return  this.content; }

    public String getPassword() {
        return this.password;
    }

    //POST생성자?
    //PostRequestDto에 넣을 title,writer,content,password를 get방식으로 저장한다.
    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
