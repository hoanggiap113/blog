package com.blog.modal.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Category")
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
}
