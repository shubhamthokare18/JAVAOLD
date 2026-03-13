package com.hostel.management.system.dto;

import lombok.Data;

@Data
public class OtpLoginRequest {

    private String identifier;   // phone OR email
    private String otp;

}