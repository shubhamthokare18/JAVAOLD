//package com.example.rabbitmq_demo.consumer;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//import com.example.rabbitmq_demo.config.RabbitMQConfig;
//
//@Service
//public class MessageConsumer {
//
//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void receive(String message) {
//        System.out.println("📩 Received message: " + message);
//    }
//}
