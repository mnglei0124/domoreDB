package com.example.innoctivedb.service;

import com.example.innoctivedb.model.Post;
import com.example.innoctivedb.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> updatePost(Long id, Post updatedPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setName(updatedPost.getName());
            post.setLocation(updatedPost.getLocation());
            post.setDate(updatedPost.getDate());
            post.setCategory(updatedPost.getCategory());
            postRepository.save(post);
            return Optional.of(post);
        } else  {
            return Optional.empty();
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
