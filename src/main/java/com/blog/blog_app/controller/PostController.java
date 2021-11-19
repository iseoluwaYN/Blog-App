package com.blog.blog_app.controller;

import com.blog.blog_app.data.dto.PostUpdateDto;
import com.blog.blog_app.data.model.Post;
import com.blog.blog_app.exceptions.PostDoesNotExistException;
import com.blog.blog_app.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PostController {

    @Autowired
    PostServiceImpl postServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> savePost(@RequestBody Post post){
            return new ResponseEntity<>(postServiceImpl.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(postServiceImpl.findById(id), HttpStatus.FOUND);
        } catch (PostDoesNotExistException e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author){
        return  new ResponseEntity<>(postServiceImpl.findByAuthor(author), HttpStatus.FOUND);
    }

    @GetMapping("{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title){
            return new ResponseEntity<>(postServiceImpl.findByTitle(title), HttpStatus.FOUND);
    }

    @PostMapping("{update}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostUpdateDto newUpdate){
        return new ResponseEntity<>(postServiceImpl.updatePost(id,newUpdate), HttpStatus.OK);
    }

    @DeleteMapping("{delete}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        postServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
