package com.nguyenanhtu.exercise401.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "variants")
public class Variants {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_option_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private VariantOption variantOption;

    public String getProductId() {
        return product != null && product.getId() != null ? product.getId().toString() : null;
    }

    public String getVariantOptionId() {
        return variantOption != null && variantOption.getId() != null ? variantOption.getId().toString() : null;
    }

    private String sku;
    private String barcode;
    private String image;
    private Double price;
    private Double comparePrice;
    private Double costPrice;
    private Integer inventory;
}
