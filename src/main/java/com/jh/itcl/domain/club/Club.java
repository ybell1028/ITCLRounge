package com.jh.itcl.domain.club;

import com.jh.itcl.domain.BaseTimeEntity;
import com.jh.itcl.domain.post.Post;
import com.jh.itcl.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "club_tb")
public class Club extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long club_idx;
    // 참조 방향 Post -> User
    @Column(length = 50, nullable = false)
    private String club_name;
    private String club_url;
    private String club_logo;
    private Timestamp submit_start;
    private Timestamp submit_end;
    private Timestamp submit_result;
    private Timestamp interview_start;
    private Timestamp interview_end;
    private Timestamp interview_result;

    @Builder
    public Club(String club_name, String club_url, String club_logo, Timestamp submit_start, Timestamp submit_end, Timestamp submit_result, Timestamp interview_start, Timestamp interview_end, Timestamp interview_result) {
        this.club_name = club_name;
        this.club_url = club_url;
        this.club_logo = club_logo;
        this.submit_start = submit_start;
        this.submit_end = submit_end;
        this.submit_result = submit_result;
        this.interview_start = interview_start;
        this.interview_end = interview_end;
        this.interview_result = interview_result;
    }
}
