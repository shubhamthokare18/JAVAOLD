package com.example.attendance.config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends GenericFilter {
    private final JwtUtil jwtUtil;
    private final com.example.attendance.service.JwtUserDetailsService userDetailsService;

    public JwtAuthFilter(JwtUtil jwtUtil, com.example.attendance.service.JwtUserDetailsService uds) {
        this.jwtUtil = jwtUtil; this.userDetailsService = uds;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String auth = req.getHeader("Authorization");
        if (auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            try {
                String username = jwtUtil.extractUsername(token);
                var user = userDetailsService.loadUserByUsername(username);
                var authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (Exception e) {
                // ignore -> not authenticated
            }
        }
        chain.doFilter(request, response);
    }
}
