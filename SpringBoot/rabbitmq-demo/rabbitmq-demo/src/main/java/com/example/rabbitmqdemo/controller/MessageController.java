package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @GetMapping("/send/{msg}")
    public String send(@PathVariable String msg) {
        producer.sendMessage(msg);
        return "Message sent: " + msg;
    }
}
