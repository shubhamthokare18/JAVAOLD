package com.example.attendance.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender mailSender;
    public MailService(JavaMailSender jms){ this.mailSender = jms; }

    public void sendSimpleEmail(String to, String subj, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to); msg.setSubject(subj); msg.setText(body);
        mailSender.send(msg);
    }
}
