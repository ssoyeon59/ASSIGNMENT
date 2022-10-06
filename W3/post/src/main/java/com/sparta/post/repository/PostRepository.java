package com.sparta.post.repository;

import com.sparta.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> { //기본적인 CRUD를 처리할 수있는 getOne,findById, findAll, save, delete등 함수가 정의되어있다
    List<Post> findAllByOrderByModifiedAtDesc(); // findAll 다 찾아라
                                                // ByOrderBy 이 기준으로 정렬해줘
                                                // ModifiedAt라는 (멤버변수)으로
                                                // Desc 내림차순
}
