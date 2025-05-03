package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.NotificationRequest;
import com.nguyenanhtu.exercise401.entity.Notification;
import com.nguyenanhtu.exercise401.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable UUID id) {
        return notificationService.getNotificationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Notification>> getNotificationsByAccountId(@PathVariable UUID accountId) {
        List<Notification> notifications = notificationService.getNotificationsByAccountId(accountId);
        return ResponseEntity.ok(notifications);
    }

    @PostMapping
    public ResponseEntity<Notification> addNotification(@RequestBody NotificationRequest notificationRequest) {
        Notification createdNotification = notificationService.addNotification(notificationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNotification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable UUID id, @RequestBody NotificationRequest notificationRequest) {
        try {
            Notification updatedNotification = notificationService.updateNotification(id, notificationRequest);
            return ResponseEntity.ok(updatedNotification);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable UUID id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}