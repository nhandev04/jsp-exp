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
@Table(name = "product_shipping_info")
public class ProductShippingInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private BigDecimal weight = BigDecimal.ZERO;

    public static enum WeightUnit {
        KG, G
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "weight_unit", nullable = false, length = 10)
    private WeightUnit weightUnit;

    @Column(nullable = false)
    private BigDecimal volume = BigDecimal.ZERO;

    public static enum VolumeUnit {
        L, ML
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "volume_unit", nullable = false, length = 10)
    private VolumeUnit volumeUnit;

    @Column(name = "dimension_width", nullable = false)
    private BigDecimal dimensionWidth = BigDecimal.ZERO;

    @Column(name = "dimension_height", nullable = false)
    private BigDecimal dimensionHeight = BigDecimal.ZERO;

    @Column(name = "dimension_depth", nullable = false)
    private BigDecimal dimensionDepth = BigDecimal.ZERO;

    public static enum DimensionUnit {
        MM, CM, M, KM
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "dimension_unit", nullable = false, length = 10)
    private DimensionUnit dimensionUnit;
}
