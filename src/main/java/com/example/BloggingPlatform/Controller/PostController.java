package com.example.BloggingPlatform.Controller;

import com.example.BloggingPlatform.dto.PostDto;
import com.example.BloggingPlatform.exception.ResourceNotFoundException;
import com.example.BloggingPlatform.model.Post;
import com.example.BloggingPlatform.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        try{
            List<Post> posts = postService.getAllPosts();
            if(posts.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No blog Posts found");
            }
            return ResponseEntity.ok(posts);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Post post = postService.getPostById(id);
        if(post != null){
            return ResponseEntity.ok(post);
        }else{
            throw new ResourceNotFoundException("Post with ID" + id +"not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto) {
        try {
            Post createdPost = postService.createPost(postDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error" + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable String id,@Valid @RequestBody PostDto postDto) {
        try{
            Post updatedPost = postService.updatePost(id, postDto);
            return ResponseEntity.ok(updatedPost);
        }catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error" + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        try{
            postService.deletePost(id);
            return ResponseEntity.ok("Post with ID" + id + " deleted successfully");
        }catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error" + ex.getMessage());
        }

    }
    @GetMapping("/search")
    public ResponseEntity<?> searchPosts(@RequestParam String query) {
        try {
            List<Post> posts = postService.searchPosts(query);
            if (posts.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No posts found for query: " + query);
            }
            return ResponseEntity.ok(posts);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: " + ex.getMessage());
        }
    }


}
