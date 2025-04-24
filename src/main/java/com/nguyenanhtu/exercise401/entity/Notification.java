package com.nguyenanhtu.exercise401.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private StaffAccount account;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "seen", nullable = false)
    private Boolean seen = false;

    @Column(name = "receive_time")
    private LocalDateTime receiveTime;

    @Column(name = "notification_expiry_date")
    private LocalDate notificationExpiryDate;
}
