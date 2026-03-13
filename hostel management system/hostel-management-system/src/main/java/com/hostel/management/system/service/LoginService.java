package com.hostel.management.system.service;

import com.hostel.management.system.entity.Owner;
import com.hostel.management.system.repository.OwnerRepository;
import com.hostel.management.system.security.JwtUtil;
import com.hostel.management.system.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final PasswordEncoder passwordEncoder;
    private final OwnerRepository ownerRepository;
    private final OtpService otpService;
    private final JwtUtil jwtUtil;

    // LOGIN WITH USERNAME + PASSWORD
    public String loginWithPassword(String username, String password){
        Owner owner = ownerRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(!passwordEncoder.matches(password, owner.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(username);
    }

    // SEND PHONE LOGIN OTP
    public void sendPhoneLoginOtp(String phone){

        phone = PhoneUtil.normalize(phone);

        System.out.println("PHONE RECEIVED : " + phone);

        Owner owner = ownerRepository
                .findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Phone not registered"));

        otpService.sendPhoneOtp(phone);
    }

    // SEND EMAIL LOGIN OTP
    public void sendEmailLoginOtp(String email){
        email = email.trim().toLowerCase();
        Owner owner = ownerRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not registered"));
        otpService.sendEmailOtp(email);
    }

    // LOGIN USING OTP
    public String loginWithOtp(String identifier, String otp){

        if(identifier.contains("@")){
            identifier = identifier.trim().toLowerCase();
        }else{
            identifier = PhoneUtil.normalize(identifier);
        }

        boolean valid = otpService.verifyOtp(identifier, otp);

        if(!valid){
            throw new RuntimeException("Invalid OTP");
        }

        Owner owner;

        if(identifier.contains("@")){
            owner = ownerRepository
                    .findByEmail(identifier)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }else{
            owner = ownerRepository
                    .findByPhone(identifier)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        return jwtUtil.generateToken(owner.getUsername());
    }
}