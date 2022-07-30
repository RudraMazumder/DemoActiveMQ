package com.example.demo.clients;

import com.example.demo.model.Employee;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class Producer {

    private static final Logger log= LoggerFactory.getLogger(Producer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    @Value("${active-mq.consumerA}")
    private String queue;

    public void sendMessage(Employee message){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            jmsTemplate.convertAndSend(new ActiveMQTopic(topic), message);
            log.info("Publish employee message for employee {}", message.getFirstName());
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }

}
