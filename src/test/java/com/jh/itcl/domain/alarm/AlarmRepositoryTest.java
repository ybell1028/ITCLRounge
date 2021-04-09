package com.jh.itcl.domain.alarm;

import com.jh.itcl.domain.club.Club;
import com.jh.itcl.domain.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlarmRepositoryTest {
    @Autowired
    AlarmRepository alarmRepository;

    @AfterEach
    public void teardown() {
        alarmRepository.deleteAll();
    }

    @Test
    public void 알람저장_불러오기(){
        String id = "ybell1028";
        String platform = "google";
        String name = "황종훈";
        String email = "ybell1028@gmail.com";

        User user = User.builder()
                .id(id)
                .platform(platform)
                .name(name)
                .email(email)
                .picture(null)
                .access_token(null)
                .build();

        String club_name = "YAPP";
        String club_url = "http://yapp.co.kr/";
        String club_logo = "https://image.rocketpunch.com/company/41341/yapp_logo_1542481743.jpeg?s=400x400&t=inside";
        Club yapp = Club.builder()
                .club_name(club_name)
                .club_url(club_url)
                .club_logo(club_logo)
                .submit_start(null)
                .submit_end(null)
                .submit_result(null)
                .interview_start(null)
                .interview_end(null)
                .interview_result(null)
                .build();

        //given
        alarmRepository.save(Alarm.builder()
                .user(user)
                .club(yapp)
                .build()
        );

        //when
        List<Alarm> alarmList = alarmRepository.findAll();

        //then
        Alarm alarm = alarmList.get(0);
        assertThat(alarm.getClub().getClub_name()).isEqualTo(club_name);
        assertThat(alarm.getClub().getClub_url()).isEqualTo(club_url);
        assertThat(alarm.getClub().getClub_logo()).isEqualTo(club_logo);
    }
}
