package com.project.newsletter.service;

import com.project.newsletter.dto.DetailsAVRO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private static final Logger log = LogManager.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, DetailsAVRO> template;

    @Value("${topic.name}")
    private String topicName;

    public void send(DetailsAVRO details) {
        log.info("Inside KafkaProducer >> send");
        CompletableFuture<SendResult<String, DetailsAVRO>> future = template.send(topicName, UUID.randomUUID().toString(), details);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message = [{}] with offset = [{}]", details, result.getRecordMetadata().offset());
            }
            else {
                log.error("Unable to sent message = [{}] due to: [{}]", details, ex.getMessage());
            }
        });
    }
}
