package com.logging.kafka.producer.kafkaproducer.loggingfilter.dto;

import java.util.Date;

public class SuccessRequestLog {

    private String id;

    private String successRequest;

    private String successResponse;

    private String method;

    private String queryParam;

    private String headers;

    private String uri;

    private Date createdTime;

    private Date requestTime;

    private Date responsetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuccessRequest() {
        return successRequest;
    }

    public void setSuccessRequest(String successRequest) {
        this.successRequest = successRequest;
    }

    public String getSuccessResponse() {
        return successResponse;
    }

    public void setSuccessResponse(String successResponse) {
        this.successResponse = successResponse;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(Date responsetime) {
        this.responsetime = responsetime;
    }
}
