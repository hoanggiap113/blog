package com.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Comment{
        private String commentId;
        private String userId;
        private String userName;
        private String content;
        private LocalDateTime createdAt;
}

