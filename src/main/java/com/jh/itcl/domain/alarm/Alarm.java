package com.jh.itcl.domain.alarm;

import com.jh.itcl.domain.BaseTimeEntity;
import com.jh.itcl.domain.club.Club;
import com.jh.itcl.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "alarm_tb")
public class Alarm extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarm_idx;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "club_idx")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Club club;

    public Alarm(User user, Club club) {
        this.user = user;
        this.club = club;
    }
}
