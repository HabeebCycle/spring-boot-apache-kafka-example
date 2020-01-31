package com.habeebcycle.springbootkafka.producer;

import com.habeebcycle.springbootkafka.service.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer implements ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${habeebcycle.kafka.topic}")
    private String kafkaTopic;

    @Override
    public void send() {
        for(int i = 0; i < 100; i++){
            System.out.print(i);
            kafkaTemplate.send(kafkaTopic, Integer.toString(i), "Test message - " + i );
        }
    }

    
    
}