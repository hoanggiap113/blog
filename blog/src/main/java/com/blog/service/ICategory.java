package com.blog.service;

import com.blog.modal.request.CategoryRequest;
import com.blog.modal.response.CategoryResponse;
import com.blog.modal.response.PostResponse;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface ICategory {
    List<CategoryResponse> getCategories();
    List<PostResponse> getPostsByCategory(String id);
    CategoryResponse saveCategory(CategoryRequest categoryRequest);
    CategoryResponse updateCategory(String id,CategoryRequest categoryRequest);
    void deleteCategory(String id);
}
