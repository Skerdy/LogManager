package com.skerdy.logkafkarayonit.Kafka;


import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.skerdy.logkafkarayonit.models.CustomDeserializer;
import com.skerdy.logkafkarayonit.models.CustomSerializer;
import com.skerdy.logkafkarayonit.models.Log;
import com.skerdy.logkafkarayonit.models.LogSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LogProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> logProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class);
        return props;
    }


    @Bean
    public ProducerFactory<String, Log> produceLogFactory(){
        return new DefaultKafkaProducerFactory<>(logProducerConfigs());
    }


    @Bean
    public KafkaTemplate<String, Log> logLafkaTemplate() {
        return new KafkaTemplate<>(produceLogFactory());
    }

}
