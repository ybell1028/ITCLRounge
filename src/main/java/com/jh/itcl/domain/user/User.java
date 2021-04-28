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

    @Builder
    public User(String id, String platform, String name, String email, String picture) {
        this.id = id;
        this.platform = platform;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .platform(platform)
                .name(name)
                .email(email)
                .picture(picture)
                .build();
    }
}
