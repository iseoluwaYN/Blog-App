package com.blog.blog_app.services;

import com.blog.blog_app.data.dto.PostUpdateDto;
import com.blog.blog_app.data.model.Post;
import com.blog.blog_app.data.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
@Sql("/db/insert.sql")
public class PostUpdateTest {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;


    @Test
    @Transactional
    void updatePostTest(){
        Post post = postRepository.findById(11L).orElse(null);
        assertThat(post).isNotNull();
        assertThat(post.getAuthor()).isEqualTo("Titobi");

        PostUpdateDto updateDto = new PostUpdateDto();
        updateDto.setPostBody("My first book");
        updateDto.setAuthor("Ligali");

        post = postService.updatePost(11L, updateDto);
        assertThat(post.getAuthor()).isEqualTo("Ligali");
    }
}

