package com.jh.itcl.domain.club;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
// 별 다른 설정 없이 @SpringBootTest를 사용할 경우 H2 데이터베이스 사용
@SpringBootTest
public class ClubRepositoryTest {
    @Autowired
    ClubRepository clubRepository;

    @AfterEach // JUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드
    public void cleanup() {
        clubRepository.deleteAll();
    }

    @Test
    public void 클럽저장_불러오기() {
        String club_name = "YAPP";
        String club_url = "http://yapp.co.kr/";
        String club_logo = "https://image.rocketpunch.com/company/41341/yapp_logo_1542481743.jpeg?s=400x400&t=inside";
        LocalDateTime submit_start = LocalDateTime.of(2021, 1, 25, 0, 0, 0); // 서류 전형 시작
        LocalDateTime submit_end = LocalDateTime.of(2021, 1, 29, 18, 0, 0);;
        LocalDateTime submit_result = LocalDateTime.of(2021, 2, 3, 0, 0, 0);;
        LocalDateTime interview_start = LocalDateTime.of(2021, 2, 6, 0, 0, 0);
        LocalDateTime interview_end = LocalDateTime.of(2021, 2, 8, 0, 0, 0);;
        LocalDateTime interview_result = LocalDateTime.of(2021, 2, 8, 12, 0, 0);;

        //given
        clubRepository.save(Club.builder()
                .club_name(club_name)
                .club_url(club_url)
                .club_logo(club_logo)
                .submit_start(submit_start)
                .submit_end(submit_end)
                .submit_result(submit_result)
                .interview_start(interview_start)
                .interview_end(interview_end)
                .interview_result(interview_result)
                .build()
        );

        //when
        List<Club> clubList = clubRepository.findAll();

        //then - 예상값과 동일한지 확인
        Club club = clubList.get(0);
        assertThat(club.getClub_name()).isEqualTo(club_name);
        assertThat(club.getClub_url()).isEqualTo(club_url);
        assertThat(club.getClub_logo()).isEqualTo(club_logo);
        assertThat(club.getSubmit_start()).isEqualTo(submit_start);
    }
}
