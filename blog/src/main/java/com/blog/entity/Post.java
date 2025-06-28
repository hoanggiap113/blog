package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection="posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private String authorId;
    private String authorName;
    private LocalDateTime createdAt;
    private String category;
    private List<Comment> comments;

}

