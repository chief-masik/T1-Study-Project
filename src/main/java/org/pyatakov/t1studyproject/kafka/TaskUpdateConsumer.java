package org.pyatakov.t1studyproject.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pyatakov.t1studyproject.dto.TaskStatusUpdate;
import org.pyatakov.t1studyproject.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskUpdateConsumer {
    private static final String BLANK_EMAIL_MESSAGE = "The task with id = %d got a new status '%s'";

    private final NotificationService emailNotificationService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${application.kafka.consumer.topic}")
    public void listen(List<String> messages) {
        List<TaskStatusUpdate> listTaskStatusUpdate = parseMessages(messages);

        if (!listTaskStatusUpdate.isEmpty()) {
            Map<Long, String> taskIdToMessageMap = convertTaskStatusUpdatesToMap(listTaskStatusUpdate);
            emailNotificationService.sendNotificationsByTaskId(taskIdToMessageMap);
        }
    }

    private List<TaskStatusUpdate> parseMessages(List<String> messages) {
        return messages
                .stream()
                .map(message -> {
                    TaskStatusUpdate taskStatusUpdate = null;
                    try {
                        taskStatusUpdate = objectMapper.readValue(message, TaskStatusUpdate.class);
                        log.debug("Consumer successful reading of TaskStatusUpdate: {}", taskStatusUpdate);
                    } catch (IOException exception) {
                        log.error("Error reading TaskStatusUpdate. Message: {}, Exception: {}", message, exception.getMessage());
                    }
                    return taskStatusUpdate;
                })
                .filter(Objects::nonNull)
                .toList();
    }

    private Map<Long, String> convertTaskStatusUpdatesToMap(List<TaskStatusUpdate> listTaskStatusUpdate) {
        return listTaskStatusUpdate.stream().collect(
                Collectors.toMap(
                        TaskStatusUpdate::getId,
                        taskStatusUpdate -> String.format(BLANK_EMAIL_MESSAGE, taskStatusUpdate.getId(), taskStatusUpdate.getStatus())
                )
        );
    }
}
