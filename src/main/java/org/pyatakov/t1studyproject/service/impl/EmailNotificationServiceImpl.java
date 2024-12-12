package org.pyatakov.t1studyproject.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.pyatakov.t1studyproject.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("emailNotificationService")
public class EmailNotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotificationByUserId(Long userId, String message) {
        // TODO Использовать spring-boot-starter-mail, и в NotificationService реализовать отправку email
        log.info("sendNotificationByUserId call");
    }

    @Override
    public void sendNotificationsByUserId(Map<Long, String> notificationMap) {
        // TODO Использовать spring-boot-starter-mail, и в NotificationService реализовать отправку email
        log.info("sendNotificationsByUserId call");
    }
}
