package com.blog.service;

import com.blog.modal.request.LoginRequest;
import com.blog.modal.request.SignupRequest;
import com.blog.modal.response.LoginResponse;
import com.blog.modal.response.UserDetailResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUser {
    UserDetailResponse saveUser(SignupRequest request);
    LoginResponse login(LoginRequest request);
}
