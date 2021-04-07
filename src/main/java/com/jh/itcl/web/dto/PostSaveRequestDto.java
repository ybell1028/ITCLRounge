package com.jh.itcl.web.dto;

import com.jh.itcl.domain.post.Post;
import com.jh.itcl.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String category;
    private String title;
    private String contents;

    @Builder
    public PostSaveRequestDto(String category, String title, String contents) {
        this.category = category;
        this.title = title;
        this.contents = contents;
    }

    public Post toEntity(User user){
        return Post.builder()
                .user(user)
                .category(category)
                .title(title)
                .contents(contents)
                .build();
    }
}
