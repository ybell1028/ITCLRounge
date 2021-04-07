package com.jh.itcl.domain.user;

import com.jh.itcl.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name="user_tb")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_idx;
    @Column(length = 30, nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    private String platform;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String email;
    private String picture;
    private String access_token;
//    user_idx     serial      not null
//    constraint user_tb_pk
//    primary key,
//    id           varchar(30) not null,
//    platform     varchar(20) not null,
//    name         varchar(20) not null,
//    email        varchar(40) not null,
//    picture      varchar,
//    access_token varchar,
//    created_at   timestamp,
//    modified_at  timestamp,
//    club         varchar
//    constraint user_tb_club_fkey
//    references club_tb

    @Builder
    public User(String id, String platform, String name, String email, String picture, String access_token) {
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
