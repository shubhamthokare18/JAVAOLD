package com.example.attendance.service;

import com.example.attendance.repository.UserRepository;
import com.example.attendance.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo; this.encoder = encoder;
    }

    public User register(String username, String rawPassword) {
        var user = User.builder()
                .username(username)
                .password(encoder.encode(rawPassword))
                .role("ROLE_USER")
                .build();
        return repo.save(user);
    }
}
