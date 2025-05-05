package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipping_zones")
public class ShippingZone extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "display_name", nullable = false, length = 255)
    private String displayName;

    @Column(name = "active")
    private Boolean active = false;

    @Column(name = "free_shipping")
    private Boolean freeShipping = false;

    @Column(name = "rate_type", length = 64)
    private String rateType;

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
