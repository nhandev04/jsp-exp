package com.nguyenanhtu.exercise401.entity;

import java.io.Serializable;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_supliers")
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
