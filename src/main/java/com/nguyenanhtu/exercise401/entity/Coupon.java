package com.nguyenanhtu.exercise401.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "code", nullable = false, length = 50, unique = true)
    private String code;

    @Column(name = "discount_value", precision = 19, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "discount_type", nullable = false, length = 50)
    private String discountType;

    @Column(name = "times_used", nullable = false, precision = 19, scale = 2)
    private BigDecimal timesUsed = BigDecimal.ZERO;

    @Column(name = "max_usage", precision = 19, scale = 2)
    private BigDecimal maxUsage;

    @Column(name = "order_amount_limit", precision = 19, scale = 2)
    private BigDecimal orderAmountLimit;

    @Column(name = "coupon_start_date")
    private LocalDateTime couponStartDate;

    @Column(name = "coupon_end_date")
    private LocalDateTime couponEndDate;
}
