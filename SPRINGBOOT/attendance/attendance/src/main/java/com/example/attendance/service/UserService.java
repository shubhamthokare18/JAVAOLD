package com.example.attendance.service;

import com.example.attendance.component.JwtUtil;
import com.example.attendance.dto.LoginRequest;
import com.example.attendance.dto.RegisterUserRequest;
import com.example.attendance.entity.Role;
import com.example.attendance.entity.User;
import com.example.attendance.repository.RoleRepository;
import com.example.attendance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public void register(RegisterUserRequest req) {

        Role role = roleRepo.findByName("ROLE_" + req.getRole().toUpperCase())
                .orElseThrow(() -> new RuntimeException("Invalid role"));

        User user = User.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .email(req.getEmail())
                .enabled(true)
                .roles(Set.of(role))
                .build();

        userRepo.save(user);
    }

    public String login(LoginRequest req) {
        User user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
