package com.jh.itcl.domain.post;

import com.jh.itcl.domain.user.User;
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
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @AfterEach // JUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        User user = new User("ybell1028", "google", "황종훈", "ybell1028@gmail.com", null, null);

        String title = "테스트 게시글";
        String category = "개발";
        String contents = "테스트 본문";
        Integer view = 0;
        Integer love = 0;

        //given
        postRepository.save(Post.builder()
                .user(user)
                .category(category)
                .title(title)
                .contents(contents)
                .view(view)
                .love(love)
                .build()
        );

        //when
        List<Post> postList = postRepository.findAll();

        //then - 예상값과 동일한지 확인
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getCategory()).isEqualTo(category);
        assertThat(post.getContents()).isEqualTo(contents);
        assertThat(post.getView()).isEqualTo(view);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        User user = new User("ybell1028", "google", "황종훈", "ybell1028@gmail.com", null, null);

        String title = "테스트 게시글";
        String category = "개발";
        String contents = "테스트 본문";
        Integer view = 0;
        Integer love = 0;

        //given
        postRepository.save(Post.builder()
                .user(user)
                .category(category)
                .title(title)
                .contents(contents)
                .view(view)
                .love(love)
                .build()
        );

        //when
        List<Post> postsList = postRepository.findAll();

        //then
        Post post = postsList.get(0);

        System.out.println(">>>>>>>> created_at = " + post.getCreated_at()
                + ", modified_at = " + post.getModified_at());

        assertThat(post.getCreated_at()).isAfter(now);
        assertThat(post.getModified_at()).isAfter(now);
    }
}
