package com.blog.modal.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private String authorId;
    private String authorName;
    private List<String> tags;
    private LocalDateTime createdAt;
    private String category;
    private List<Comment> comments;

}

