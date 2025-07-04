package com.blog.repository;

import com.blog.modal.entity.Role;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
    Optional<Role> findByName(String name);
}
