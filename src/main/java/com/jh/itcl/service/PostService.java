package com.jh.itcl.service;

import com.jh.itcl.domain.post.PostRepository;
import com.jh.itcl.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    //DB의 접근이 하나라도 실패시 rollback
    //비지니스 로직과 트랜잭션 관리는 모두 Service에 하기때문에 Service 메소드는 @Transactional를 사용
    public Long save(PostSaveRequestDto requestDto){
        //header를 통해 Access Token을 받으면 user_idx를 추출해서 PostSaveRequestDto를 toEntitiy로 생성
        return postRepository.save(requestDto.toEntity()).getPost_idx();
    }
}
