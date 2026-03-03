package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.publisher.MessageProducer4;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchanges")
public class MessageController4 {

    private final MessageProducer4 producer;

    public MessageController4(MessageProducer4 producer) {
        this.producer = producer;
    }

    @PostMapping("/direct")
    public String direct(@RequestParam String msg) {
        producer.sendToDirect(msg);
        return "Sent to Direct Exchange";
    }

    @PostMapping("/fanout")
    public String fanout(@RequestParam String msg) {
        producer.sendToFanout(msg);
        return "Sent to Fanout Exchange";
    }

    @PostMapping("/topic")
    public String topic(@RequestParam String routingKey, @RequestParam String msg) {
        producer.sendToTopic(routingKey, msg);
        return "Sent to Topic Exchange";
    }

    @PostMapping("/headers")
    public String headers(@RequestParam String msg) {
        producer.sendToHeaders(msg);
        return "Sent to Headers Exchange";
    }
}
