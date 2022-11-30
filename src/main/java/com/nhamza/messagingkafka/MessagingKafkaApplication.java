package com.nhamza.messagingkafka;

import com.nhamza.messagingkafka.kafkaTemplate.MyKafkaTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MessagingKafkaApplication {

    public static MyKafkaTemplate kafkaTemplate;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MessagingKafkaApplication.class, args);
        boolean start = true;
        int i = 0;
        while (start) {
            Thread.sleep(100);
            i++;
            log.info("mytopic", "message to mytopic" + i);
            kafkaTemplate.sendMessage("message to mytopic"+i);
            if (i == 10) {
                start = false;
            }
        }
        Thread.sleep(10000000);
    }

    @Autowired
    public void setKafkaTemplate(MyKafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
