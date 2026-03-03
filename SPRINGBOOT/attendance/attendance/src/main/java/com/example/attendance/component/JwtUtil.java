package com.example.attendance.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.DoubleStream;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final String secret = "SECRET_KEY_ABC";

    public String generateToken(String username) {
        DoubleStream Jwts;
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
