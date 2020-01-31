package com.habeebcycle.springbootkafka.controller;

import com.habeebcycle.springbootkafka.producer.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public String sendMessage(){
        kafkaProducer.send();
        return "Message produced and sent successfuly.";
    }
}