package com.blog.blog_app.services;

import com.blog.blog_app.data.dto.PostUpdateDto;
import com.blog.blog_app.data.model.Post;
import com.blog.blog_app.exceptions.PostDoesNotExistException;
import com.blog.blog_app.exceptions.PostException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post savePost(Post post);
    Post findById(Long id) throws PostDoesNotExistException;
    Post findByTitle(String title);
    List<Post> findByAuthor(String author);
    void delete(Long id);
    Post updatePost(Long id, PostUpdateDto updateDto);
}
