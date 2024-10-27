package com.project.newsletter.service;

import com.project.newsletter.dto.EmployeeAVRO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, EmployeeAVRO> consumerRecord) {
        String key = consumerRecord.key();
        EmployeeAVRO value = consumerRecord.value();

        log.info("Avro message received for key: {}value : {}", key, value);

    }
}
