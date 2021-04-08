package com.jh.itcl.service;

import com.jh.itcl.domain.user.User;
import com.jh.itcl.domain.user.UserReposiroty;
import com.jh.itcl.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserReposiroty userReposiroty;

    @Transactional
    public UserResponseDto findByIdx(Long user_idx){
        User user = userReposiroty.findById(user_idx)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 유저가 존재하지 않습니다. id = " + user_idx));
        return new UserResponseDto(user);
    }
}
