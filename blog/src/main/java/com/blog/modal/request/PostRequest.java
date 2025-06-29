package com.blog.modal.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    @NotBlank(message = "tittle cannot be blank")
    private String tittle;

    private String content;

    @NotNull(message = "authorId cannot be null")
    private String authorId;
    private String authorName;

    @NotNull(message = "tags cannot be null")
    private List<String> tags;

    @NotNull(message = "Category Cannot be null")
    private String category;
}
