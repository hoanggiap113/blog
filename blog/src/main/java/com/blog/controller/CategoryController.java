package com.blog.controller;

import com.blog.modal.entity.Category;
import com.blog.modal.request.CategoryRequest;
import com.blog.modal.response.CategoryResponse;
import com.blog.modal.response.PostResponse;
import com.blog.service.impl.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories(){
        try{
            List<CategoryResponse> categories = categoryService.getCategories();
            return ResponseEntity.ok(categories);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<List<PostResponse>> getPost(@PathVariable("id") String id){
        try{
            List<PostResponse> posts = categoryService.getPostsByCategory(id);
            return ResponseEntity.ok(posts);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    /*
        Các phần sau đây là của admin:
        Thêm
        Sửa
        Xóa
     */
    @PostMapping("")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        try{
            CategoryResponse categoryResponse = categoryService.saveCategory(categoryRequest);
            return ResponseEntity.ok(categoryResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") String id, @Valid @RequestBody CategoryRequest categoryRequest){
        try{
            return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequest));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id){
        try{
            categoryService.deleteCategory(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
