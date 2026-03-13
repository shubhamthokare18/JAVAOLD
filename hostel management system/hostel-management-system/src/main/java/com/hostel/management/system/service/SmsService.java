package com.hostel.management.system.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    /*
        SEND OTP SMS
     */
    public void sendSmsOtp(String phone,String otp){

        System.out.println("--------------------------------------------------");
        System.out.println("SMS SENT TO : " + phone);
        System.out.println("OTP : " + otp);
        System.out.println("--------------------------------------------------");

    }

    /*
        SEND REGISTRATION SUCCESS SMS
     */
    public void sendRegistrationSuccessSms(String phone,String hostelName){

        System.out.println("--------------------------------------------------");
        System.out.println("SMS SENT TO : " + phone);
        System.out.println("Registration Successful for hostel : " + hostelName);
        System.out.println("--------------------------------------------------");

    }

}