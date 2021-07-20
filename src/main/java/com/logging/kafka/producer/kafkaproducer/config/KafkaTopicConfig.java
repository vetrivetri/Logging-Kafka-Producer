package com.logging.kafka.producer.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic sucessLoggingTopic() {
        return TopicBuilder.name("microservice-error-logging").build();
    }

    @Bean
    public NewTopic errorLoggingTopic() {
        return TopicBuilder.name("microservice-success-logging").build();
    }
}
