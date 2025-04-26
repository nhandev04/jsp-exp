package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}