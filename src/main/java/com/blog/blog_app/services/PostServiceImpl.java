package com.blog.blog_app.services;

import com.blog.blog_app.data.dto.PostUpdateDto;
import com.blog.blog_app.data.model.Post;
import com.blog.blog_app.data.repository.PostRepository;
import com.blog.blog_app.exceptions.PostDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostMapper postMapper;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post)  {
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long id) throws PostDoesNotExistException {
//        Optional<Post> returnedPost = postRepository.findById(id);
//        if (returnedPost.isPresent()){
//            return returnedPost.get();
//        }
//        throw new PostDoesNotExistException("Post does not exist");
        return  postRepository.findById(id).orElse(null);
    }

    @Override
    public Post findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }

    @Override
    public void delete(Long id) {
       postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Long id, PostUpdateDto updateDto) {
        if(updateDto != null) {

            Post postToUpdate = postRepository.getById(id);

//            if(postToUpdate == null) {
                postMapper.mapDtoToPost(updateDto, postToUpdate);
                return postRepository.save(postToUpdate);
//            }else throw new IllegalArgumentException("Post not found");
        }
        else throw new NullPointerException("Post doesn't exist");
    }

}
