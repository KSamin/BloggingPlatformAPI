package com.example.BloggingPlatform.services;

import com.example.BloggingPlatform.dto.PostDto;
import com.example.BloggingPlatform.exception.ResourceNotFoundException;
import com.example.BloggingPlatform.model.Post;
import com.example.BloggingPlatform.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post getPostById(String id) {
        return postRepository.findById(String.valueOf(id)).orElse(null);
    }
    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCategory(postDto.getCategory());
        post.setTags(postDto.getTags());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }
    public Post updatePost(String id, PostDto postDto) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new ResourceNotFoundException("Post with ID " + id + " not found");
        }
            Post post = optionalPost.get();
            post.setTitle(postDto.getTitle());
            post.setContent(postDto.getContent());
            post.setCategory(postDto.getCategory());
            post.setTags(postDto.getTags());
            post.setUpdatedAt(LocalDateTime.now());


            return postRepository.save(post);

    }
    public void deletePost(String id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isEmpty()) {
            throw new ResourceNotFoundException("Post with ID " + id + " not found");
        }
        postRepository.deleteById(id);
    }
    public List<Post> searchPosts(String query) {
        return postRepository.searchPosts(query);
    }

}
