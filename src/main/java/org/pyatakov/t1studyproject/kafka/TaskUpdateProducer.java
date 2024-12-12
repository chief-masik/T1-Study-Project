package org.pyatakov.t1studyproject.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pyatakov.t1studyproject.dto.TaskStatusUpdate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskUpdateProducer {
    private final KafkaTemplate<String, TaskStatusUpdate> kafkaTemplate;

    @Value("${application.kafka.producer.topic}")
    private String TOPIC;

    public void sendTaskStatusUpdate(TaskStatusUpdate taskStatusUpdate) {
        kafkaTemplate.send(TOPIC, taskStatusUpdate.getId().toString(), taskStatusUpdate);
        log.debug("Producer successfully sent a message TaskStatusUpdate: {}", taskStatusUpdate);
    }
}
