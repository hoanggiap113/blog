package com.blog.repository;

import com.blog.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositry extends MongoRepository<User,String> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
