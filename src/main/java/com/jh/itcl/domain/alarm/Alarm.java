package com.jh.itcl.domain.alarm;

import com.jh.itcl.domain.BaseTimeEntity;
import com.jh.itcl.domain.club.Club;
import com.jh.itcl.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name="alarm_tb")
public class Alarm extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long alarm_idx;
    // 참조 방향 Post -> User
    @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn 어노테이션은 외래 키를 매핑 할 때 사용합니다.
    // name 속성에는 매핑 할 외래 키 이름을 지정합니다.
    @JoinColumn(name = "user_idx")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    // 참조 방향 Post -> User
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "club_name")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Club club;

    @Builder
    public Alarm(User user, Club club) {
        this.user = user;
        this.club = club;
    }
}
