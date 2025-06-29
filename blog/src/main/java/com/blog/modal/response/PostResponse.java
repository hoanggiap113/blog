package com.blog.modal.response;

import com.blog.modal.entity.Comment;
import com.blog.modal.entity.Post;
import lombok.*;
import java.util.List;
import com.blog.util.NullSafeUtil;
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {
    private String id;
    private String title;
    private String content;
    private String authorId;
    private String authorName;
    private String category;
    private List<Comment> comments;


    public static PostResponse from(Post post) {
        if (post == null) {
            return null;
        }
        return PostResponse.builder()
                .id(NullSafeUtil.getOrNull(post, Post::getId))
                .title(NullSafeUtil.getOrDefault(post, Post::getTitle, "Untitled Post"))
                .content(NullSafeUtil.getOrDefault(post, Post::getContent, "No content"))
                .authorId(NullSafeUtil.getOrNull(post, Post::getAuthorId))
                .authorName(NullSafeUtil.getOrDefault(post, Post::getAuthorName, "Anonymous"))
                .category(NullSafeUtil.getOrNull(post, Post::getCategory))
                .comments(NullSafeUtil.getOrNull(post, Post::getComments))
                .build();
    }

}
