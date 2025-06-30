package com.blog.service.impl;

import com.blog.exception.DataNotFoundException;
import com.blog.modal.entity.Role;
import com.blog.modal.entity.User;
import com.blog.modal.request.LoginRequest;
import com.blog.modal.request.SignupRequest;
import com.blog.modal.response.LoginResponse;
import com.blog.modal.response.UserDetailResponse;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;
import com.blog.security.jwt.JwtService;
import com.blog.security.service.CustomUserDetailsService;
import com.blog.service.IUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUser {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    private boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    private boolean isUsernameExist(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDetailResponse saveUser(SignupRequest request) {
        boolean emailExist = isEmailExist(request.getEmail());
        boolean usernameExist = isUsernameExist(request.getUsername());
        if (emailExist) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already exist");
        }
        if (usernameExist) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username is already exist");
        }

        List<Role> userRoles = request.getRoles().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new DataNotFoundException("Role not found: " + roleName)))
                .collect(Collectors.toList());

        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(userRoles);
        userRepository.save(user);

        return UserDetailResponse.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .roles(userRoles.stream().map(Role::getName).collect(Collectors.toList()))
                .build();
    }


    @Override
    public LoginResponse login(LoginRequest request) {
        System.out.println("===> Login request: " + request.getEmail() + " | password: " + request.getPassword());

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));
        System.out.println("===> User found in DB: " + user.getEmail());
        System.out.println("===> Encoded password in DB: " + user.getPassword());

        boolean passwordMatches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!passwordMatches) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password or Email is incorrect");
        }

        // Load UserDetails từ userDetailsService

        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtService.generateToken(userDetails);

        UserDetailResponse userDetailResponse = UserDetailResponse.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .build();

        return LoginResponse.builder()
                .token(token)
                .user(userDetailResponse)
                .build();
    }

}
