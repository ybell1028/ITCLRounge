package com.jh.itcl.web.controller;

import com.jh.itcl.domain.user.User;
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
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        User user = requestDto.getUser();
        System.out.println(user.getName());
        return postService.save(requestDto);
    }
}
