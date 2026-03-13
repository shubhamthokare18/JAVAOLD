package com.hostel.management.system.entity;

import com.hostel.management.system.enumtype.OtpStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/*
 This entity stores OTP for phone and email verification
*/

@Entity
@Data
public class OtpVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long otpId;

    // phone or email
    private String identifier;

    // generated OTP
    private String otpCode;

    // PHONE or EMAIL
    private String type;

    // expiry time
    private LocalDateTime expiryTime;

    @Enumerated(EnumType.STRING)
    private OtpStatus status;

}