package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.NotificationRequest;
import com.nguyenanhtu.exercise401.entity.Notification;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationService {
    List<Notification> getAllNotifications();
    
    Optional<Notification> getNotificationById(UUID id);
    
    List<Notification> getNotificationsByAccountId(UUID accountId);

    Notification addNotification(NotificationRequest request);
    
    Notification updateNotification(UUID id, NotificationRequest request);
    
    void deleteNotification(UUID id);
}