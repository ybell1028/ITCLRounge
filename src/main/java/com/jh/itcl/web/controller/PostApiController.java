package com.jh.itcl.web.controller;

import com.jh.itcl.service.PostService;
import com.jh.itcl.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/post")
    //header를 통해 Access Token을 받으면 user_idx를 추출해서 PostSaveRequestDto를 toEntitiy로 생성
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }
}
