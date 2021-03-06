package com.jh.itcl.web.dto;

import com.jh.itcl.domain.post.Post;
import com.jh.itcl.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private User user;
    private String category;
    private String title;
    private String contents;
    private Integer view;
    private Integer love;

    @Builder
    public PostSaveRequestDto(User user, String category, String title, String contents, Integer view, Integer love) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.view = view;
        this.love = love;
    }


    public Post toEntity(){
        //header를 통해 Access Token을 받으면 user_idx를 추출해서 PostSaveRequestDto를 toEntitiy로 생성
        return Post.builder()
                .user(user)
                .category(category)
                .title(title)
                .contents(contents)
                .view(view)
                .love(love)
                .build();
    }
}
