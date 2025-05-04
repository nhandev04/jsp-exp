package com.nguyenanhtu.exercise401.controller.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class NotificationRequest {
    private UUID id;
    private UUID accountId;
    private String title;
    private String content;
    private Boolean seen;
    private LocalDateTime receiveTime;
    private LocalDate notificationExpiryDate;
}