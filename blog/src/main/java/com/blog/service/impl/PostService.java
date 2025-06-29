package com.blog.service.impl;

import com.blog.exception.DataNotFoundException;
import com.blog.modal.entity.Post;
import com.blog.modal.request.PostRequest;
import com.blog.repository.PostRepository;
import com.blog.modal.response.PostResponse;
import com.blog.service.IPost;
import com.blog.util.NullSafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class PostService implements IPost {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<PostResponse> getAll() {
        List<PostResponse> posts = postRepository.findAll().stream().map(PostResponse::from).collect(Collectors.toList());
        return posts;
    }

    @Override
    public PostResponse addPost(PostRequest postRequest) {
        Post post = Post.builder()
                .title(NullSafeUtil.getOrDefault(postRequest, PostRequest::getTittle, "Untitled Post"))
                .content(NullSafeUtil.getOrDefault(postRequest, PostRequest::getContent, "No content provided."))
                .authorId(NullSafeUtil.getOrNull(postRequest, PostRequest::getAuthorId))
                .authorName(NullSafeUtil.getOrDefault(postRequest, PostRequest::getAuthorName, "Anonymous"))
                .tags(NullSafeUtil.getOrNull(postRequest, PostRequest::getTags))
                .category(NullSafeUtil.getOrNull(postRequest, PostRequest::getCategory))
                .comments(null)
                .build();

        post = postRepository.save(post);
        return PostResponse.from(post);
    }


    @Override
    public PostResponse findPostById(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found"));
        return PostResponse.from(post);
    }

    @Override
    public PostResponse updatePost(String id,PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found"));
        post.setTitle(NullSafeUtil.getOrDefault(postRequest,PostRequest::getTittle,post.getTitle()));
        post.setContent(NullSafeUtil.getOrDefault(postRequest,PostRequest::getContent,post.getContent()));
        post.setCategory(NullSafeUtil.getOrDefault(postRequest,PostRequest::getCategory,post.getCategory()));
        post.setTags(NullSafeUtil.getOrDefault(postRequest,PostRequest::getTags,post.getTags()));
        return PostResponse.from(postRepository.save(post));
    }

    @Override
    public void deletePost(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Data not found"));
        postRepository.delete(post);
    }
}
