package com.example.attendance.dto;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class RegisterRequest {
    @NotBlank private String username;
    @NotBlank private String password;
}
