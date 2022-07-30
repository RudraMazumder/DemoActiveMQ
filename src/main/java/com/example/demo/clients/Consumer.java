package com.example.demo.clients;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class Consumer{

    private static final Logger log= LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${active-mq.consumerA}")
    public void onMessage(Employee message) {
        try{
            //do additional processing
            log.info("Received Message: "+ message);
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
