package com.logging.kafka.producer.kafkaproducer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.ErrorRequestLog;
import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.SuccessRequestLog;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class ErrorRequestSerializer implements Serializer<ErrorRequestLog> {

    @Override
    public byte[] serialize(String arg0, ErrorRequestLog errorRequestLog) {
        byte[] serializedBytes = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            serializedBytes = objectMapper.writeValueAsString(errorRequestLog).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serializedBytes;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // TODO Auto-generated method stub
    }
}
