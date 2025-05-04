package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.NotificationRequest;
import com.nguyenanhtu.exercise401.entity.Notification;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.NotificationRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.NotificationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final StaffAccountRepository staffAccountRepository;

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
    public Notification addNotification(NotificationRequest request) {
        Notification notification = new Notification();
        return saveNotification(notification, request);
    }

    @Override
    public Notification updateNotification(UUID id, NotificationRequest request) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
        
        return saveNotification(notification, request);
    }

    @Override
    public void deleteNotification(UUID id) {
        notificationRepository.deleteById(id);
    }
    
    private Notification saveNotification(Notification notification, NotificationRequest request) {
        // Set basic properties
        notification.setTitle(request.getTitle());
        notification.setContent(request.getContent());
        notification.setSeen(request.getSeen());
        notification.setReceiveTime(request.getReceiveTime());
        notification.setNotificationExpiryDate(request.getNotificationExpiryDate());
        
        // Set account if provided
        if (request.getAccountId() != null) {
            StaffAccount account = staffAccountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getAccountId()));
            notification.setAccount(account);
        }
        
        // Save and return the notification
        return notificationRepository.save(notification);
    }
}