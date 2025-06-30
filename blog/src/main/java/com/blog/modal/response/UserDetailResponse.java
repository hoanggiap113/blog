package com.blog.modal.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailResponse {
    private String id;
    private String name;
    private String email;
    private List<String> roles;
}
