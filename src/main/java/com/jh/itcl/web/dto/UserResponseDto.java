package com.jh.itcl.web.dto;

import com.jh.itcl.domain.user.User;

public class UserResponseDto {
    private String id;
    private String platform;
    private String name;
    private String email;
    private String picture;
    private String access_token;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.platform = entity.getPlatform();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.access_token = entity.getAccess_token();
    }
}
