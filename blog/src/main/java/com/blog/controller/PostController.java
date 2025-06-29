package com.blog.controller;

import com.blog.modal.request.PostRequest;
import com.blog.modal.response.PostResponse;
import com.blog.service.impl.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("")
    public ResponseEntity<List<PostResponse>> getPosts() {
        try{
            List<PostResponse> posts = postService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(posts);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable String id) {
        try{
            PostResponse post = postService.findPostById(id);
            return ResponseEntity.status(HttpStatus.OK).body(post);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public ResponseEntity<?> addPost(@Valid @RequestBody PostRequest postRequest) {
        try{
            PostResponse postResponse = postService.addPost(postRequest);
            return ResponseEntity.status(HttpStatus.OK).body(postResponse);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable String id, @Valid @RequestBody PostRequest postRequest) {
        try{
            PostResponse postResponse = postService.updatePost(id, postRequest);
            return ResponseEntity.status(HttpStatus.OK).body(postResponse);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id) {
        try{
            postService.deletePost(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
