package com.blog.modal.entity;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Document(collection="User")
@Getter
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private List<String> role;
    private LocalDateTime createAt;
}
