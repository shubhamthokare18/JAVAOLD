package com.hostel.management.system.controller;

import com.hostel.management.system.dto.LoginRequest;
import com.hostel.management.system.dto.OtpLoginRequest;
import com.hostel.management.system.dto.ApiResponse;
import com.hostel.management.system.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /*
        LOGIN WITH USERNAME PASSWORD
     */
    @PostMapping("/password")
    public ApiResponse login(@RequestBody LoginRequest request){

        String token = loginService.loginWithPassword(
                request.getUsername(),
                request.getPassword()
        );

        return ApiResponse.builder()
                .success(true)
                .message("Login successful")
                .data(token)
                .build();
    }

    /*
        SEND PHONE OTP FOR LOGIN
     */
    @PostMapping("/phone/send-otp")
    public ApiResponse sendPhoneOtp(@RequestParam String phone){

        loginService.sendPhoneLoginOtp(phone);

        return ApiResponse.builder()
                .success(true)
                .message("OTP sent to phone")
                .build();
    }

    /*
        SEND EMAIL OTP FOR LOGIN
     */
    @PostMapping("/email/send-otp")
    public ApiResponse sendEmailOtp(@RequestParam String email){

        loginService.sendEmailLoginOtp(email);

        return ApiResponse.builder()
                .success(true)
                .message("OTP sent to email")
                .build();
    }

    /*
        LOGIN WITH OTP
     */
    @PostMapping("/otp")
    public ApiResponse loginWithOtp(@RequestBody OtpLoginRequest request){

        String token = loginService.loginWithOtp(
                request.getIdentifier(),
                request.getOtp()
        );

        return ApiResponse.builder()
                .success(true)
                .message("Login successful")
                .data(token)
                .build();
    }

}