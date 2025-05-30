package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_coupons")
public class ProductCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", nullable = false)
    private Coupon coupon;

    public String getProduct() {
        return product.getId() != null ? product.getId().toString() : null;
    }

    public String getCoupon() {
        return coupon.getId() != null ? coupon.getId().toString() : null;
    }
}
