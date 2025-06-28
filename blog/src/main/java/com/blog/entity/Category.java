package com.blog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Category")
public class Category {
    @Id
    private String id;
    private String name;
}
