package com.sparta.post.service;

import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.dto.PostResponseDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service //스프링에게 이 클래스는 서비스임을 명시
public class PostService {

    //final : 서비스에게 꼭 필요한 녀석임을 명시
    // 생성자를 통해, Service 클래스를 만들대 꼭 Repository를 넣어주도록 스프링에게 알려줌
    private final PostRepository postRepository;

//    @Transactional //전체 게시글 조회
//    public Post post() {
//        return (Post) Collections.singletonList(postRepository.findAllByOrderByModifiedAtDesc());
//    }

    @Transactional //게시글 등록
    public Post postSave(PostRequestDto requestDto) {
        Post post = new Post(requestDto); //post객체를 새로 만든다.
        return postRepository.save(post); //repository에 저장 할 수 있게 한다.
    }

    // 비밀번호 일치여부를 판단하는 메서드입니다 파라미터로 게시글의 아이디를 받는다.
    public boolean comparePassword (Long id, PostRequestDto postPasswordDto) {
        // 아이디, 패스워드로 게시글을 찾아오고 찾아온 게시글의 아이디와 파라미터로 받은 아이디를 비교합니다
        Post post = postRepository.findById(id).orElseThrow( //가져온 값이 null일때 예외 발생
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        //일치하면 true, 일치하지않으면 false를 받습니다
        if (Objects.equals(postPasswordDto.getPassword(), post.getPassword())) {
            return true;
        } else {
            return false;
        }
//        return postPasswordDto.getPassword().equals(post.getPassword()); //이렇게도 쓸수 있었다.
    }

    //게시글 수정하기
    @Transactional //SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    //id와 PostRequestDto의 정보를 받은 update메서드이다
    public Long update(Long id, PostRequestDto requestDto) {
        //post는 postRepositoru에서 id를 찾고 일치하지않으면 존재하지 않는다는 메세지를 띄웁니다.
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }


    public List<PostResponseDto> findAllPost(){
        // 전체 게시글을 찾아온다.
        List<Post> allPost = postRepository.findAllByOrderByModifiedAtDesc();
        //PostResponseDto 리스트를 담을 리스트를 만들어준다.
        List<PostResponseDto> resultList = new ArrayList<>();
        //allPost의 길이만큼 post를 등록시킨다.
        for (Post post : allPost) {
//            PostResponseDto postResponseDto = new PostResponseDto();
            //builder을 사용해 필요한 title,writher,createdAt,modiviesAt를 얻는다
            PostResponseDto dto = PostResponseDto.builder()
                    .title(post.getTitle())
                    .writer(post.getWriter())
                    .createdAt(String.valueOf(post.getCreatedAt()))
                    .modifiedAt(String.valueOf(post.getModifiedAt()))
                    .build();
            //dto를 PostResponseDto의 resultList에 더한다
            resultList.add(dto);
        }
        return resultList;
    }
}
