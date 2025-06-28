package com.blog.repository;

import com.blog.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findByTitleContaining(String title);

}
