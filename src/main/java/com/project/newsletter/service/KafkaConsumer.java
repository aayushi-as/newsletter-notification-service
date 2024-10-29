package com.project.newsletter.service;

import com.project.newsletter.dto.DetailsAVRO;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, DetailsAVRO> consumerRecord) throws MessagingException {
        log.info("Inside KafkaConsumer >> read");
        String key = consumerRecord.key();
        DetailsAVRO value = consumerRecord.value();
        log.info("Avro message received for key: {}, value : {}", key, value);

        emailService.sendBulkEmail(value.getUsers(), value.getNewsletter());
    }
}
