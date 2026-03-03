package com.example.rabbitmq_demo.publisher;

import com.example.rabbitmq_demo.config.RabbitMQConfig4;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageProducer4 {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer4(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Direct Exchange
    public void sendToDirect(String msg) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig4.DIRECT_EXCHANGE,
                RabbitMQConfig4.DIRECT_ROUTING_KEY,
                msg
        );
        System.out.println("✅ Sent to DIRECT: " + msg);
    }

    // Fanout Exchange
    public void sendToFanout(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig4.FANOUT_EXCHANGE, "", msg);
        System.out.println("✅ Sent to FANOUT: " + msg);
    }

    // Topic Exchange
    public void sendToTopic(String routingKey, String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig4.TOPIC_EXCHANGE, routingKey, msg);
        System.out.println("✅ Sent to TOPIC (" + routingKey + "): " + msg);
    }

    // Headers Exchange
    public void sendToHeaders(String msg) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("format", "pdf");
        headers.put("type", "report");

        rabbitTemplate.convertAndSend(
                RabbitMQConfig4.HEADERS_EXCHANGE,
                "",
                msg,
                m -> {
                    m.getMessageProperties().getHeaders().putAll(headers);
                    return m;
                }
        );
        System.out.println("✅ Sent to HEADERS: " + msg);
    }
}
