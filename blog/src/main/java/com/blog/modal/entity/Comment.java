package com.blog.modal.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Comment{
        private String commentId;
        private String userId;
        private String username;
        private String content;
        private LocalDateTime createdDate;
}

