package com.blog.modal.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password Require")
    private String password;
}
