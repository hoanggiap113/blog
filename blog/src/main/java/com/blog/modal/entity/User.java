package com.blog.modal.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private List<Role> roles;
    private LocalDateTime createAt;
    private String bio;
}
