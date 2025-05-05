package com.nguyenanhtu.exercise401.entity;

import java.io.Serializable;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_suppliers")
public class ProductSupplier extends BaseEntity {

    @EmbeddedId
    @JsonIgnore
    private ProductSupplierId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("supplierId")
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "is_primary")
    @JsonIgnore
    private Boolean isPrimary = false;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class ProductSupplierId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "product_id", nullable = false)
        private UUID productId;

        @Column(name = "supplier_id", nullable = false)
        private UUID supplierId;
    }

    // Helper methods to get string representations of IDs
    public String getProduct() {
        return product != null && product.getId() != null ? product.getId().toString() : null;
    }

    public String getSupplier() {
        return supplier != null && supplier.getId() != null ? supplier.getId().toString() : null;
    }

}