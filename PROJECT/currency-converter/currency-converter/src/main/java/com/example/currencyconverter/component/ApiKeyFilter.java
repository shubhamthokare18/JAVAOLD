package com.example.currencyconverter.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiKeyFilter extends HttpFilter {

    @Value("${app.api.key}")
    private String expectedKey;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        String key = req.getHeader("X-API-KEY");

        if (!expectedKey.equals(key)) {
            res.setStatus(401);
            res.getWriter().write("Invalid API Key");
            return;
        }

        req.setAttribute("apiUser", "default-user");
        chain.doFilter(req, res);
    }
}
