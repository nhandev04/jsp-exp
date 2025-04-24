package com.nguyenanhtu.exercise401.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "product_supliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSuplier {

    @EmbeddedId
    private ProductSuplierId id;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class ProductSuplierId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "product_id", nullable = false)
        private UUID productId;

        @Column(name = "supplier_id", nullable = false)
        private UUID supplierId;
    }
}
