//package com.example.rabbitmq_demo.publisher;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.example.rabbitmq_demo.config.RabbitMQConfig;
//
//@Service
//public class MessageProducer {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void send(String message) {
//        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
//        System.out.println("✅ Sent message: " + message);
//    }
//}
