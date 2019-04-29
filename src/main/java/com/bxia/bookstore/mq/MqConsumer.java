package com.bxia.bookstore.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class MqConsumer {

    @KafkaListener(topics = {"test"})
    public void onMessage(ConsumerRecord<Integer, String> record){
        log.info("received message [{}] from topic [test]", record);
    }
}