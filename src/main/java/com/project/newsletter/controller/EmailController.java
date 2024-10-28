package com.project.newsletter.controller;

import com.project.newsletter.dto.EmployeeAVRO;
import com.project.newsletter.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

//    @Autowired
//    private KafkaProducer kafkaProducer;
//
//    @PostMapping("/dev-test")
//    public String devTestSendEvent(@RequestBody EmployeeAVRO employee) {
//        kafkaProducer.send(employee);
//        return "message published !";
//    }
}
