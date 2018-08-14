package com.skerdy.logkafkarayonit.Kafka.Producers;

import com.skerdy.logkafkarayonit.models.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducer   {



    private static final Logger LOG = LoggerFactory.getLogger(LogProducer.class);



    @Autowired
    private KafkaTemplate<String, Log> logKafkaTemplate;

    @Value("${app.topic.log_topic}")
    private String topic;

    public void send(Log log){
        System.out.println("Para dergimit te log");
        logKafkaTemplate.send(topic, log);
        System.out.println("Pas dergimit te log");
    }
}
