//package com.example.rabbitmq_demo.controller;
//
//import com.example.rabbitmq_demo.publisher.MessageProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/messages")
//public class MessageController {
//
//    @Autowired
//    private MessageProducer producer;
//
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String msg) {
//        producer.send(msg);
//        return "Message sent: " + msg;
//    }
//}
