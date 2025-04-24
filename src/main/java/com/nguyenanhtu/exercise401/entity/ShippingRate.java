package com.nguyenanhtu.exercise401.entity;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "shipping_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingRate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_zone_id", referencedColumnName = "id", nullable = false)
    private ShippingZone shippingZone;

    @Column(name = "weight_unit", length = 10)
    private String weightUnit;

    @Column(name = "min_value", nullable = false, precision = 19, scale = 2)
    private BigDecimal minValue = BigDecimal.ZERO;

    @Column(name = "max_value", precision = 19, scale = 2)
    private BigDecimal maxValue;

    @Column(name = "no_max", nullable = false)
    private Boolean noMax = true;

    @Column(name = "price", nullable = false, precision = 19, scale = 2)
    private BigDecimal price = BigDecimal.ZERO;
}
