package com.hostel.management.system.service;

import com.hostel.management.system.entity.OtpVerification;
import com.hostel.management.system.enumtype.OtpStatus;
import com.hostel.management.system.repository.OtpRepository;
import com.hostel.management.system.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository otpRepository;
    private final EmailService emailService;
    private final SmsService smsService;

    private String generateOtp(){

        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

        return String.valueOf(otp);
    }

    public void sendPhoneOtp(String phone){

        phone = PhoneUtil.normalize(phone);

        String otp = generateOtp();

        OtpVerification entity = new OtpVerification();

        entity.setIdentifier(phone);
        entity.setOtpCode(otp);
        entity.setType("PHONE");
        entity.setStatus(OtpStatus.PENDING);
        entity.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepository.save(entity);

        smsService.sendSmsOtp(phone,otp);
    }

    public void sendEmailOtp(String email){

        String otp = generateOtp();

        OtpVerification entity = new OtpVerification();

        entity.setIdentifier(email);
        entity.setOtpCode(otp);
        entity.setType("EMAIL");
        entity.setStatus(OtpStatus.PENDING);
        entity.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepository.save(entity);

        emailService.sendEmailOtp(email, otp);
    }

    public boolean verifyOtp(String identifier, String otp){

        OtpVerification entity = otpRepository.findLatestOtp(identifier);

        if(entity == null){
            throw new RuntimeException("OTP not generated");
        }

        if(entity.getExpiryTime().isBefore(LocalDateTime.now())){

            entity.setStatus(OtpStatus.EXPIRED);
            otpRepository.save(entity);

            throw new RuntimeException("OTP expired");
        }

        if(!entity.getOtpCode().equals(otp)){
            throw new RuntimeException("Invalid OTP");
        }

        entity.setStatus(OtpStatus.VERIFIED);
        otpRepository.save(entity);

        return true;
    }

    public boolean isOtpVerified(String identifier){

        OtpVerification otp = otpRepository.findLatestOtp(identifier);

        if(otp == null){
            return false;
        }

        return otp.getStatus() == OtpStatus.VERIFIED;
    }

}