package org.pyatakov.t1studyproject.service;

import java.util.Map;

public interface NotificationService {

    void sendNotificationByUserId(Long userId, String message);

    void sendNotificationsByUserId(Map<Long, String> userIdToMessageMap);
}
