package com.jh.itcl.domain.club;

import com.jh.itcl.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name="club_tb")
public class Club extends BaseTimeEntity {
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long club_idx;
    @Id
    @Column(length = 40, nullable = false)
    private String club_name;
    private String club_url;
    private String club_logo;
    private LocalDateTime submit_start; // 서류 전형 시작
    private LocalDateTime submit_end;
    private LocalDateTime submit_result;
    private LocalDateTime interview_start;
    private LocalDateTime interview_end;
    private LocalDateTime interview_result;

    @Builder
    public Club(String club_name, String club_url, String club_logo, LocalDateTime submit_start, LocalDateTime submit_end, LocalDateTime submit_result, LocalDateTime interview_start, LocalDateTime interview_end, LocalDateTime interview_result) {
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
