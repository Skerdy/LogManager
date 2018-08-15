package com.skerdy.logkafkarayonit.Kafka.Consumers;


import com.skerdy.logkafkarayonit.Services.LogService;
import com.skerdy.logkafkarayonit.WebSocket.WebSocketController;
import com.skerdy.logkafkarayonit.controllers.LogController;
import com.skerdy.logkafkarayonit.models.Log;
import com.skerdy.logkafkarayonit.models.LogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(LogConsumer.class);

    @Autowired
    private WebSocketController webSocketController;

    @Autowired
    private LogController logController;

    @Autowired
    private LogService logService;

    @KafkaListener(topics = "${app.topic.log_topic}")
    public void listen(@Payload Log log){
        this.webSocketController.sendLog(log);
       // this.logService.save(new LogEntity(log.getDate(), log.getType(), log.getMessage()));
        System.out.println("Consumer got this LOG : " + log.getMessage());
    }
}
