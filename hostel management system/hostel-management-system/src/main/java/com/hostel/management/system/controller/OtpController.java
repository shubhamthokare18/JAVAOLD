package com.hostel.management.system.controller;

import com.hostel.management.system.dto.OtpRequest;
import com.hostel.management.system.dto.OtpVerifyRequest;
import com.hostel.management.system.dto.ApiResponse;
import com.hostel.management.system.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    /*
     Send phone OTP
    */
    @PostMapping("/send-phone")
    public ApiResponse sendPhoneOtp(@RequestBody OtpRequest request){

        otpService.sendPhoneOtp(request.getIdentifier());

        return ApiResponse.builder()
                .success(true)
                .message("Phone OTP sent successfully")
                .build();
    }

    /*
     Send email OTP
    */
    @PostMapping("/send-email")
    public ApiResponse sendEmailOtp(@RequestBody OtpRequest request){

        otpService.sendEmailOtp(request.getIdentifier());

        return ApiResponse.builder()
                .success(true)
                .message("Email OTP sent successfully")
                .build();
    }

    /*
     Verify OTP
    */
    @PostMapping("/verify")
    public ApiResponse verifyOtp(@RequestBody OtpVerifyRequest request){

        try{

            boolean valid = otpService.verifyOtp(
                    request.getIdentifier(),
                    request.getOtp()
            );

            return ApiResponse.builder()
                    .success(valid)
                    .message(valid ? "OTP verified successfully" : "Invalid OTP")
                    .build();

        }
        catch(Exception e){

            return ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }

    }

}