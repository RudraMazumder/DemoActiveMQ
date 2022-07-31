package com.example.demo.clients;

import com.example.demo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AnotherConsumer {

    private static final Logger log= LoggerFactory.getLogger(AnotherConsumer.class);

    @JmsListener(destination = "${active-mq.consumerB}")
    public void onMessage(Employee message) {
        try{
            log.info("Received Message: "+ message);
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
