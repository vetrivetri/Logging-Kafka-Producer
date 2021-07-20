package com.logging.kafka.producer.kafkaproducer.loggingfilter.log;

import com.logging.kafka.producer.kafkaproducer.loggingfilter.dto.SuccessRequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SuccessLogService {

    @Autowired
    KafkaTemplate<String,SuccessRequestLog> successKafkaTemplate;

    public void successLogHandling(CustomLogHttpRequestWrapper requestWrapper, CustomLogHttpResponseWrapper responseWrapper,
                                    Date requestTime, Date responseTime){
        SuccessRequestLog successRequestLog = new SuccessRequestLog();
        successRequestLog.setUri(requestWrapper.getRequestURI());
        successRequestLog.setMethod(requestWrapper.getMethod());
        successRequestLog.setQueryParam(requestWrapper.getQueryString());
        successRequestLog.setSuccessRequest(new String(requestWrapper.getByteArray()));
        successRequestLog.setSuccessResponse(new String((responseWrapper.getBaos().toByteArray())));
        successRequestLog.setRequestTime(requestTime);
        successRequestLog.setResponsetime(responseTime);
        successKafkaTemplate.send("microservice-success-logging",successRequestLog);

    }

}
