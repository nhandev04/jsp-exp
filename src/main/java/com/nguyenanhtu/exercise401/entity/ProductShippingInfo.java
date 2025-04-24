package com.nguyenanhtu.exercise401.entity;

import java.util.UUID;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_shipping_info")
public class ProductShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private BigDecimal weight = BigDecimal.ZERO;

    @Column(name = "weight_unit", nullable = false, length = 10)
    private String weightUnit;

    @Column(nullable = false)
    private BigDecimal volume = BigDecimal.ZERO;

    @Column(name = "volume_unit", nullable = false, length = 10)
    private String volumeUnit;

    @Column(name = "dimension_width", nullable = false)
    private BigDecimal dimensionWidth = BigDecimal.ZERO;

    @Column(name = "dimension_height", nullable = false)
    private BigDecimal dimensionHeight = BigDecimal.ZERO;

    @Column(name = "dimension_depth", nullable = false)
    private BigDecimal dimensionDepth = BigDecimal.ZERO;

    @Column(name = "dimension_unit", nullable = false, length = 10)
    private String dimensionUnit;
}
