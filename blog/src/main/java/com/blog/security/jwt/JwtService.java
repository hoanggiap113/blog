package com.blog.security.jwt;


import com.blog.modal.entity.User;
import com.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return jwtUtil.validateToken(token, userDetails.getUsername());
    }

    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }

    public User getUserFromToken(String token) {
        String username = extractUsername(token);
        return userRepository.findByEmail(username).orElse(null);
    }
}

