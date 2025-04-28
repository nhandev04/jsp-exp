package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    @Query("SELECT n FROM Notification n WHERE n.account.id = :accountId")
    List<Notification> findByAccountId(@Param("accountId") UUID accountId);
}
