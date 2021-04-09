package com.jh.itcl.web;

import com.jh.itcl.domain.post.Post;
import com.jh.itcl.domain.post.PostRepository;
import com.jh.itcl.domain.user.User;
import com.jh.itcl.web.dto.PostSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void tearDown() throws Exception{
        postRepository.deleteAll();
    }

    @Test
    public void Post_등록된다() throws Exception {
        // given
        // 지금은 User 객체를 생성하고 있지만 후에는 access 토큰으로 정보를 받아보아야하나?
        // 아니면 access 토큰으로 만드는 객체를 Bean으로 만들어서 Autowired로 의존성을 주입해줘야 하나?
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

        String title = "테스트 게시글";
        String category = "개발";
        String contents = "테스트 본문";
        Integer view = 0;
        Integer love = 0;

        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .user(user)
                .category(category)
                .title(title)
                .contents(contents)
                .view(view)
                .love(love)
                .build();

        String url = "http://localhost:" + port + "/api/post";

        //when - url로 만들어 둔 requestDto를 보낸다.
        //mvc.perform - 생성된 MockMvc를 통해 API를 테스트한다.
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getCategory()).isEqualTo(category);
        assertThat(all.get(0).getContents()).isEqualTo(contents);
        assertThat(all.get(0).getView()).isEqualTo(view);
        assertThat(all.get(0).getLove()).isEqualTo(love);
    }
}
