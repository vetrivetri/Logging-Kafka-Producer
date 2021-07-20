package com.logging.kafka.producer.kafkaproducer.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
public class TestController {

 /*   @Autowired
    LoggingKafkaSender loggingKafkaSender;*/

    @GetMapping(value="/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
      //  loggingKafkaSender.sendMessage("test","microservice-logging");
        return "Hello there!";
    }

    @PostMapping(value="/hello")
    public Object sayHelloPost(@RequestBody Object obj) {
        //loggingKafkaSender.sendMessage("test","microservice-logging");
        return obj;
    }

}
