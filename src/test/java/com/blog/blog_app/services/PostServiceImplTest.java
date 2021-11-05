package com.blog.blog_app.services;

import com.blog.blog_app.data.model.Post;
import com.blog.blog_app.data.repository.PostRepository;
import com.blog.blog_app.exceptions.PostDoesNotExistException;
import com.blog.blog_app.exceptions.PostException;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.*;


class PostServiceImplTest {

    @Mock
    PostRepository postRepositoryImpl;
    @InjectMocks
    PostService postServiceImpl;

    @BeforeEach
    void setUp() {

        postServiceImpl = new PostServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void savePostTest() throws PostException {
        Post post = new Post();
        post.setTitle("Iseoluwa ate rice");
        when(postRepositoryImpl.save(any())).thenReturn(post);

        Post returnedPost = postRepositoryImpl.save(post);
        assertThat(post).isEqualTo(returnedPost);
    }
    @Test
    void deletePostTest() throws PostDoesNotExistException {
        Post post = new Post();
        post.setId(1L);
        when(postRepositoryImpl.save(any())).thenReturn(post);

        Post returnedPost = postServiceImpl.savePost(post);
        assertThat(post).isEqualTo(returnedPost);

        when(postRepositoryImpl.findById(1L)).thenReturn(Optional.of(post));
        Post foundedPost = postServiceImpl.findById(1L);
        assertThat(foundedPost).isEqualTo(post);

        postServiceImpl.delete(1L);
        when(postRepositoryImpl.findById(1L)).thenReturn(null);
        verify(postRepositoryImpl, times(1)).deleteById(any());
    }

    @Test
    void findByTitleTest(){
        Post post = new Post();
        post.setTitle("Iseoluwa ate rice");
        when(postRepositoryImpl.save(post)).thenReturn(post);

        Post returnedPost = postServiceImpl.savePost(post);
        assertThat(post).isEqualTo(returnedPost);

        when(postRepositoryImpl.findByTitle("Iseoluwa ate rice")).thenReturn(post);
        postServiceImpl.findByTitle("Iseoluwa ate rice");
        verify(postRepositoryImpl, times(1)).findByTitle("Iseoluwa ate rice");
    }

    @Test
    void findById() throws PostDoesNotExistException, PostException {

        Post post = new Post();
//        post.setId(1L);
        when(postRepositoryImpl.save(any())).thenReturn(post);

        Post returnedPost = postServiceImpl.savePost(post);
        assertThat(post).isEqualTo(returnedPost);

        when(postRepositoryImpl.findById(1L)).thenReturn(Optional.of(post));
        Post foundedPost = postServiceImpl.findById(1L);
        assertThat(foundedPost).isEqualTo(post);
    }

    @Test
    void findByAuthorTest(){

        Post post = new Post();
        post.setAuthor("Fasoyin");
        when(postRepositoryImpl.save(post)).thenReturn(post);

        Post returnedPost = postServiceImpl.savePost(post);
        assertThat(post).isEqualTo(returnedPost);

        when(postRepositoryImpl.findByAuthor(any())).thenReturn(List.of(post));
         postServiceImpl.findByAuthor("Fasoyin");
//        assertThat(foundAuthor).isEqualTo(Lpost);
        verify(postRepositoryImpl, times(1)).findByAuthor("Fasoyin");
    }
}