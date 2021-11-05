package com.blog.blog_app.data.repository;

import com.blog.blog_app.data.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
