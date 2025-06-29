package com.blog.service;

import com.blog.modal.request.PostRequest;
import com.blog.modal.response.PostResponse;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface IPost {
    List<PostResponse> getAll();
    PostResponse addPost(PostRequest postRequest);
    PostResponse findPostById(String id);
    PostResponse updatePost(String id,PostRequest postRequest);
    void deletePost(String id);
}
