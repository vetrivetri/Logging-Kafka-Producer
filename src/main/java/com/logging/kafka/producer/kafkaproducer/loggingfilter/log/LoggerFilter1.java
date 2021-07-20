package com.logging.kafka.producer.kafkaproducer.loggingfilter.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Component
public class LoggerFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletRequest currentRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse currentResponse = (HttpServletResponse) servletResponse;

        StringBuffer requestURL = currentRequest.getRequestURL();
        log.info("Request URL: {}", requestURL);
        try {
            chain.doFilter(currentRequest, servletResponse);
        } finally {
            int status = currentResponse.getStatus();
            log.info("Response status: {}", status);
        }
    }
}
