package com._ukeCompany.delivery_app.controller;

import com._ukeCompany.delivery_app.kafkaService.KafkaConsumer;
import com._ukeCompany.delivery_app.kafkaService.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumer kafkaConsumer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic,@RequestParam String message) {
        kafkaProducer.sendMessage(topic, message);
        return "Message sent " + message;
    }

//    @GetMapping("/getMessage")
//    public String getMessage(@RequestParam String topic) {
//        kafkaConsumer.listenMessage();
//        return "Meesage " + topic;
//    }
}
