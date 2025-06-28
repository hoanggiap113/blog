package com.blog.repository;

import com.blog.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
    boolean existsByName(String name);
}
