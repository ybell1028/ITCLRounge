package com.jh.itcl.web.dto;

import com.jh.itcl.domain.user.User;
import lombok.Builder;

public class UserSaveRequestDto {
    private String id;
    private String platform;
    private String name;
    private String email;
    private String picture;
    private String access_token;

    @Builder
    public UserSaveRequestDto(String id, String platform, String name, String email, String picture, String access_token) {
        this.id = id;
        this.platform = platform;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.access_token = access_token;
    }


    public User toEntity(){
        return User.builder()
                .id(id)
                .platform(platform)
                .name(name)
                .email(email)
                .picture(picture)
                .access_token(access_token)
                .build();
    }
}
