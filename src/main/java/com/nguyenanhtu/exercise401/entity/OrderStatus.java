package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_statuses")
public class OrderStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "status_name", nullable = false, length = 255)
    private String statusName;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "privacy", length = 10)
    private String privacy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private StaffAccount updatedBy;

    public String getCreatedBy() {
        return createdBy != null ? createdBy.getId().toString() : null;
    }

    public String getUpdatedBy() {
        return updatedBy != null ? updatedBy.getId().toString() : null;
    }

}