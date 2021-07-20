package com.logging.kafka.producer.kafkaproducer.config;

import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.ErrorRequestLog;
import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.SuccessRequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//@Component
public class LoggingKafkaSender {

    private KafkaTemplate<String, SuccessRequestLog> kafkaTemplate;

    private KafkaTemplate<String, ErrorRequestLog>  kafkaErrTemplate;

    @Autowired
    void LoggingKafkaSender1(KafkaTemplate<String, SuccessRequestLog> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Autowired
    LoggingKafkaSender(KafkaTemplate<String, ErrorRequestLog> kafkaErrTemplate) {
        this.kafkaErrTemplate = kafkaErrTemplate;
    }


    public void sendMessage(SuccessRequestLog successRequestLog, String topicName) {
        kafkaTemplate.send(topicName, successRequestLog);
    }

    public void sendErrMessage(ErrorRequestLog errorRequestLog, String topicName) {
        kafkaErrTemplate.send(topicName, errorRequestLog);
    }
}
