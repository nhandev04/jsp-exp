package com.nguyenanhtu.exercise401.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(length = 255)
    private String sku;

    @Column(name = "sale_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal salePrice = BigDecimal.ZERO;

    @Column(name = "compare_price", precision = 19, scale = 2)
    private BigDecimal comparePrice = BigDecimal.ZERO;

    @Column(name = "buying_price", precision = 19, scale = 2)
    private BigDecimal buyingPrice;

    @Column(nullable = false)
    private Integer quantity = 0;

    @Column(name = "short_description", nullable = false, length = 165)
    private String shortDescription;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    public enum ProductType {
        SIMPLE,
        VARIABLE
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", length = 64)
    private ProductType productType;

    @Column(nullable = false)
    private Boolean published = false;

    @Column(name = "disable_out_of_stock", nullable = false)
    private Boolean disableOutOfStock = true;

    @Column
    private String note;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCategory> categories;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private StaffAccount updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now();
        updatedAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now();
    }
}
