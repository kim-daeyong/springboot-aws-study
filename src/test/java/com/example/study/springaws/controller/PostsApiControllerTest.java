package com.example.study.springaws.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.study.springaws.domain.posts.Posts;
import com.example.study.springaws.domain.posts.PostsRepository;
import com.example.study.springaws.dto.PostSaveRequestDto;

import org.junit.jupiter.api.AfterAll;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void testDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록() throws Exception {
        //given
        String title = "title";
        String content = "content";
        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                                                            .title(title)
                                                            .content(content)
                                                            .author("author")
                                                            .build();
                                
        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotEquals(responseEntity.getBody(), 0L);

        List<Posts> all = postsRepository.findAll();
        assertEquals(all.get(0).getTitle(), title);
        assertEquals(all.get(0).getAuthor(), "author");
        assertEquals(all.get(0).getContent(), content);
    }

}
