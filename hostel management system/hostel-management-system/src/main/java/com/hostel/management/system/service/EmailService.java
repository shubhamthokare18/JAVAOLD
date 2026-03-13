package com.hostel.management.system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    /*
        SEND OTP EMAIL
     */
    public void sendEmailOtp(String email,String otp){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Email Verification OTP");

        message.setText(
                "Your OTP for email verification is : " + otp +
                        "\n\nOTP valid for 5 minutes."
        );

        mailSender.send(message);
    }

    /*
        SEND REGISTRATION SUCCESS EMAIL
     */
    public void sendRegistrationSuccessEmail(String email,String ownerName,String hostelName){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Hostel Registration Successful");

        message.setText(
                "Hello " + ownerName + ",\n\n" +
                        "Your hostel '" + hostelName + "' has been successfully registered.\n\n" +
                        "Welcome to Hostel Management System.\n\n" +
                        "Thank You."
        );

        mailSender.send(message);
    }

}