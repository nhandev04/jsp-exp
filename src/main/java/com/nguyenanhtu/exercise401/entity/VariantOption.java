package com.nguyenanhtu.exercise401.entity;

import java.math.BigDecimal;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "variant_options")
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
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id")
    private Variants variant;

    public void setImage(Gallery image) {
        this.image = image;
    }

    public String getImage() {
        return image != null ? image.getId().toString() : null;
    }

    public String getProduct() {
        return product != null ? product.getId().toString() : null;
    }

    public String getVariant() {
        return variant != null ? variant.getId().toString() : null;
    }

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