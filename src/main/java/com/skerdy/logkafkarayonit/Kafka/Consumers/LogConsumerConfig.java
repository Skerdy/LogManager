package com.skerdy.logkafkarayonit.Kafka.Consumers;

import com.skerdy.logkafkarayonit.Kafka.CustomSerialization.CustomDeserializer;
import com.skerdy.logkafkarayonit.models.Log;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class LogConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;


    @Bean
    public Map<String, Object> logconsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "log_topic");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }



    @Bean
    public ConsumerFactory<String, Log> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(logconsumerConfigs());
    }


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Log>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Log> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}