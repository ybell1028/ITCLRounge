package com.jh.itcl.domain.post;

import com.jh.itcl.domain.BaseTimeEntity;
import com.jh.itcl.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name="post_tb")
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_idx;
    // 참조 방향 Post -> User
    @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn 어노테이션은 외래 키를 매핑 할 때 사용합니다.
    // name 속성에는 매핑 할 외래 키 이름을 지정합니다.
    // Post 엔티티의 경우 User 엔티티의 user_idx 필드를 외래 키로 가지므로, user_user_idx를 작성하면 됩니다.
    @JoinColumn(name = "user_idx")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @Column(length = 20, nullable = false)
    private String category;
    @Column(length = 40, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer view;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer love;
//    post_idx serial,
//    user_idx int references user_tb (user_idx) on delete cascade,
//    category varchar(20) not null,
//    title varchar(40) not null,
//    content varchar not null,
//    view int default 0,
//            "like" int default 0,
//    created_at timestamp,
//    modified_at timestamp

    // 우선 user_idx라는 컬럼은 만들지 않았으므로 Builder에는 포함되지 않음
    @Builder
    public Post(User user, String category, String title, String contents, Integer view, Integer love) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.view = view;
        this.love = love;
    }
}
