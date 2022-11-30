package com.nhamza.messagingkafka.kafkaTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaTemplate {

@Autowired
private KafkaTemplate kafkaTemplate;

public void sendMessage(String msg) {
    kafkaTemplate.send("mytopic",msg);
}
}