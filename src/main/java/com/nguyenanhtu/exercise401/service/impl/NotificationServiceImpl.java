package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Notification;
import com.nguyenanhtu.exercise401.repository.NotificationRepository;
import com.nguyenanhtu.exercise401.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(UUID id) {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> getNotificationsByAccountId(UUID accountId) {
        return notificationRepository.findByAccountId(accountId);
    }

    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(UUID id) {
        notificationRepository.deleteById(id);
    }
}