package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "variant_values")
public class VariantValue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id", nullable = false)

    private Variants variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_attribute_value_id", referencedColumnName = "id", nullable = false)

    private ProductAttributeValue productAttributeValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")

    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")

    private StaffAccount updatedBy;

    // Helper methods to get string representations of related entities
    public String getVariant() {
        return variant != null ? variant.getId().toString() : null;
    }

    public String getProductAttributeValue() {
        return productAttributeValue != null ? productAttributeValue.getId().toString() : null;
    }

    public String getCreatedBy() {
        return createdBy != null ? createdBy.getId().toString() : null;
    }

    public String getUpdatedBy() {
        return updatedBy != null ? updatedBy.getId().toString() : null;
    }
}
