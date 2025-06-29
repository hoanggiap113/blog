package com.blog.service.impl;

import com.blog.exception.DataNotFoundException;
import com.blog.modal.entity.Category;
import com.blog.modal.entity.Post;
import com.blog.modal.request.CategoryRequest;
import com.blog.modal.response.CategoryResponse;
import com.blog.modal.response.PostResponse;
import com.blog.repository.CategoryRepository;
import com.blog.repository.PostRepository;
import com.blog.service.ICategory;
import com.blog.util.NullSafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.*;
@Service
public class CategoryService implements ICategory {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PostRepository postRepository;

    @Override
    public List<CategoryResponse> getCategories() {
        List<CategoryResponse> categories = categoryRepository.findAll().stream()
                .map(CategoryResponse::from).collect(Collectors.toList());
        return categories;

    }

    @Override
    public List<PostResponse> getPostsByCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(()
                -> new DataNotFoundException("Cannot find category with id: " + id));
        List<Post> posts = postRepository.findByCategory(category.getName());
        return posts.stream().map(PostResponse::from).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
        Category category = new Category().builder()
                .name(categoryRequest.getName())
                .description(NullSafeUtil.getOrNull(categoryRequest,CategoryRequest::getDescription))
                .build();
        Category result = categoryRepository.save(category);
        return CategoryResponse.from(result);
    }

    @Override
    public CategoryResponse updateCategory(String id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).orElseThrow(()
                -> new DataNotFoundException("Cannot find category with id: " + id));
        category.setName(NullSafeUtil.getOrNull(categoryRequest,CategoryRequest::getName));
        category.setDescription(NullSafeUtil.getOrNull(categoryRequest,CategoryRequest::getDescription));
        Category result = categoryRepository.save(category);
        return CategoryResponse.from(result);
    }

    @Override
    public void deleteCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(()
                -> new DataNotFoundException("Cannot find category with id: " + id));
        categoryRepository.delete(category);
    }
}
