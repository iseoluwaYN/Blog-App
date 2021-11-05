package com.blog.blog_app.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Comment {
    @Id
    private Long id;
    private String email;
    private String body;
    private LocalDate datePosted;
}
