package com.nguyenanhtu.exercise401.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "variant_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariantOption {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Gallery image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(name = "sale_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal salePrice = BigDecimal.ZERO;

    @Column(name = "compare_price", precision = 19, scale = 2)
    private BigDecimal comparePrice = BigDecimal.ZERO;

    @Column(name = "buying_price", precision = 19, scale = 2)
    private BigDecimal buyingPrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity = 0;

    @Column(name = "sku", length = 255)
    private String sku;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}