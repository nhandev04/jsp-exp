package com.nguyenanhtu.exercise401.entity;

import java.util.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attributes")
public class Attribute extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "attribute_name", nullable = false, length = 255)
    private String attributeName;

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
