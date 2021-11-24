package com.blog.blog_app.controller;

import com.blog.blog_app.data.dto.PostUpdateDto;
import com.blog.blog_app.data.model.Comment;
import com.blog.blog_app.data.model.Post;
import com.blog.blog_app.exceptions.PostDoesNotExistException;
import com.blog.blog_app.services.PostService;
import com.blog.blog_app.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("")
    public ResponseEntity<?> savePost(@RequestBody Post post){
            return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(postService.findById(id), HttpStatus.FOUND);
        } catch (PostDoesNotExistException e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByAuthor/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author){
        return  new ResponseEntity<>(postService.findByAuthor(author), HttpStatus.FOUND);
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title){
            return new ResponseEntity<>(postService.findByTitle(title), HttpStatus.FOUND);
    }

    @PostMapping("{update}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostUpdateDto newUpdate){
        return new ResponseEntity<>(postService.updatePost(id,newUpdate), HttpStatus.OK);
    }

    @DeleteMapping("{delete}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/comment/{id}")
    public ResponseEntity<?> addComment(@PathVariable Long id, @RequestBody Comment comment){
        postService.createComment(id, comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
