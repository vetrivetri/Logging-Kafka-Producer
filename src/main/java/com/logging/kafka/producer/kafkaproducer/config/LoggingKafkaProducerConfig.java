package com.logging.kafka.producer.kafkaproducer.config;


import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.ErrorRequestLog;
import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.SuccessRequestLog;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LoggingKafkaProducerConfig {

    @Value("${logging.kafka.bootstrap.server}")
    private String bootstrapServers;
    @Bean
    public ProducerFactory<String, SuccessRequestLog> successProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SuccessRequestSerializer.class);
        return new DefaultKafkaProducerFactory<String,SuccessRequestLog>(configProps);
    }


    @Bean
    public KafkaTemplate<String, SuccessRequestLog> successKafkaTemplate() {
        return new KafkaTemplate<String,SuccessRequestLog>(successProducerFactory());
    }


    @Bean
    public ProducerFactory<String, ErrorRequestLog> errorProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ErrorRequestSerializer.class);
        return new DefaultKafkaProducerFactory<String,ErrorRequestLog>(configProps);
    }
    @Bean
    public KafkaTemplate<String, ErrorRequestLog> errorKafkaTemplate() {
        return new KafkaTemplate<String, ErrorRequestLog>(errorProducerFactory());
    }
}
