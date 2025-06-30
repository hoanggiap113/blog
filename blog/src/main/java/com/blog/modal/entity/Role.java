package com.blog.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("roles")
public class Role {
    private String id;
    private String name;
}
