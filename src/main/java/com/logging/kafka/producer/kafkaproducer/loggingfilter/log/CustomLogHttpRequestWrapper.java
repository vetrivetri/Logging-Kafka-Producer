package com.logging.kafka.producer.kafkaproducer.loggingfilter.log;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CustomLogHttpRequestWrapper extends HttpServletRequestWrapper {

    byte[] byteArray;
    public CustomLogHttpRequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            byteArray = IOUtils.toByteArray(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return  new CustomServletInputStream(new ByteArrayInputStream(byteArray));
    }

    public byte[] getByteArray() {
        return byteArray;
    }
}