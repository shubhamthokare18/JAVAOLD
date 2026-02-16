package com.example.rabbitmq_demo.consumer;

import com.example.rabbitmq_demo.config.RabbitMQConfig4;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer4 {

    @RabbitListener(queues = RabbitMQConfig4.DIRECT_QUEUE)
    public void consumeDirect(String msg) {
        System.out.println("📩 Direct Queue received: " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig4.FANOUT_QUEUE_1)
    public void consumeFanout1(String msg) {
        System.out.println("📩 Fanout Queue 1 received: " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig4.FANOUT_QUEUE_2)
    public void consumeFanout2(String msg) {
        System.out.println("📩 Fanout Queue 2 received: " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig4.TOPIC_QUEUE_1)
    public void consumeTopic1(String msg) {
        System.out.println("📩 Topic Queue 1 received: " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig4.TOPIC_QUEUE_2)
    public void consumeTopic2(String msg) {
        System.out.println("📩 Topic Queue 2 received: " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig4.HEADERS_QUEUE)
    public void consumeHeaders(String msg) {
        System.out.println("📩 Headers Queue received: " + msg);
    }
}
