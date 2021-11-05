package com.blog.blog_app.data.repository;

import com.blog.blog_app.data.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    List<Post> findByAuthor(String author);
}
