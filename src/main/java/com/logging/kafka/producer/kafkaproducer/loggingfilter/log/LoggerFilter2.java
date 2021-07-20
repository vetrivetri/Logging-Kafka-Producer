package com.logging.kafka.producer.kafkaproducer.loggingfilter.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.Date;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoggerFilter2 implements Filter {

    @Autowired
    SuccessLogService successLogService;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        CustomLogHttpRequestWrapper requestWrapper = new CustomLogHttpRequestWrapper( (HttpServletRequest) request);
        log.info("Request Method: {}" , requestWrapper.getMethod());
        log.info("Request URI: {}" , requestWrapper.getRequestURI());
        Date requestTime = new Date();
        log.info("Request Body: {}" , new String(requestWrapper.getByteArray()));
        CustomLogHttpResponseWrapper responseWrapper = new CustomLogHttpResponseWrapper((HttpServletResponse) response);
        chain.doFilter(requestWrapper,responseWrapper);
        log.info("Request Status: {}" , (responseWrapper.getStatus()));

        Date responseTime = new Date();
        log.info("Request Body: {}" , new String((responseWrapper.getBaos().toByteArray())));
        if(responseWrapper.getStatus() == 200){
successLogService.successLogHandling(requestWrapper,responseWrapper,requestTime,responseTime);
        }
    }



}
