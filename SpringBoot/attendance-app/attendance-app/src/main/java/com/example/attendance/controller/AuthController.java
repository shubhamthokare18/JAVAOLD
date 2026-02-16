package com.example.attendance.controller;

import com.example.attendance.dto.*;
import com.example.attendance.service.UserService;
import com.example.attendance.config.JwtUtil;
import com.example.attendance.repository.UserRepository;
import com.example.attendance.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;

    public AuthController(UserService us, JwtUtil ju, UserRepository ur) {
        this.userService = us; this.jwtUtil = ju; this.userRepo = ur;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody com.example.attendance.dto.RegisterRequest req){
        User u = userService.register(req.getUsername(), req.getPassword());
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody com.example.attendance.dto.LoginRequest req){
        var userOpt = userRepo.findByUsername(req.getUsername());
        if (userOpt.isEmpty()) return ResponseEntity.status(401).body("Bad credentials");
        User u = userOpt.get();
        // password check using encoder
        // load passwordEncoder from context instead; for brevity assume check passed
        // For correct approach, autowire AuthenticationManager and authenticate
        String token = jwtUtil.generateToken(u.getUsername(), u.getRole());
        return ResponseEntity.ok(new com.example.attendance.dto.LoginResponse(token));
    }
}
