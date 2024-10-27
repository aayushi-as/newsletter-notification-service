package com.project.newsletter.service;

import com.project.newsletter.dto.EmployeeAVRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, EmployeeAVRO> template;

    @Value("${topic.name}")
    private String topicName;

    public void send(EmployeeAVRO employee) {
        CompletableFuture<SendResult<String, EmployeeAVRO>> future = template.send(topicName, UUID.randomUUID().toString(), employee);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message = [" + employee + "] with offset = [" + result.getRecordMetadata().offset() + "]");
            }
            else {
                System.out.println("Unable to sent message = [" + employee + "] due to: " + ex.getMessage());
            }
        });
    }
}
