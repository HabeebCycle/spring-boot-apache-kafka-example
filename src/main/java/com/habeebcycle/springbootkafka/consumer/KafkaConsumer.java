package com.habeebcycle.springbootkafka.consumer;

import com.habeebcycle.springbootkafka.service.ConsumerService;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer implements ConsumerService {

    @Value("${habeebcycle.kafka.topic}")
    private String kafkaTopic;

    @KafkaListener(topics = "${habeebcycle.kafka.topic}")
    public void receive(ConsumerRecord<?, ?> record) {
        System.out.println(String.format("Topic - %s, Partition - %d, Value: %s,   Offset - %d", kafkaTopic, record.partition(), record.value(), record.offset()));
    }
    
}