package com.skerdy.logkafkarayonit.Kafka;

import com.skerdy.logkafkarayonit.WebSocket.WebSocketController;
import com.skerdy.logkafkarayonit.models.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(LogConsumer.class);

    @Autowired
    private WebSocketController webSocketController;

    @KafkaListener(topics = "${app.topic.log_topic}")
    public void listen(@Payload Log log){
        this.webSocketController.sendLog(log);
        System.out.println("Consumer got this LOG : " + log.getMessage());
    }
}