package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Notification;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationService {
    List<Notification> getAllNotifications();
    
    Optional<Notification> getNotificationById(UUID id);
    
    List<Notification> getNotificationsByAccountId(UUID accountId);
    
    Notification addNotification(Notification notification);
    
    Notification updateNotification(Notification notification);
    
    void deleteNotification(UUID id);
}