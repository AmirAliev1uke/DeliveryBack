package com._ukeCompany.delivery_app.kafkaService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listenMessage(String message) {
        System.out.println("Listening message: " + message);
    }
}
