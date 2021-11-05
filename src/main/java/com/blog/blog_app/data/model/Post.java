package com.blog.blog_app.data.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String postBody;
    private String author;

    @OneToMany
    @ToString.Exclude
    private List<Comment> comments;
    @CreationTimestamp
    private LocalDate dateCreated;
}
