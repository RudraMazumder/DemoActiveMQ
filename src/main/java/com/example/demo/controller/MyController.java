package com.example.demo.controller;

import com.example.demo.clients.Producer;
import com.example.demo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private static final Logger log= LoggerFactory.getLogger(MyController.class);

    @Autowired
    private Producer producer;

    @PostMapping("/employees")
    public void publishEmployee(@RequestBody Employee employee){
        producer.sendMessage(employee);
        log.info("employee {} is published to the topic.", employee.getFirstName());

    }

}
