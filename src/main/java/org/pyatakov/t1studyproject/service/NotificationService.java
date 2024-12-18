package org.pyatakov.t1studyproject.service;

import java.util.Map;

public interface NotificationService {

    void sendNotificationByTaskId(Long taskId, String message);

    void sendNotificationsByTaskId(Map<Long, String> taskIdToMessageMap);
}
