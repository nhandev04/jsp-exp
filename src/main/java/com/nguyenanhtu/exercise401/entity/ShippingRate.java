package com.nguyenanhtu.exercise401.entity;

import java.math.BigDecimal;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipping_rates")
public class ShippingRate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_zone_id", referencedColumnName = "id", nullable = false)
    private ShippingZone shippingZone;

    public enum WeightUnit {
        G, KG;

        @JsonCreator
        public static WeightUnit fromString(String value) {
            for (WeightUnit unit : WeightUnit.values()) {
                if (unit.name().equalsIgnoreCase(value)) {
                    return unit;
                }
            }
            throw new IllegalArgumentException("Invalid weight unit: " + value);
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "weight_unit", length = 10)
    private WeightUnit weightUnit;

    @Column(name = "min_value", nullable = false, precision = 19, scale = 2)
    private BigDecimal minValue = BigDecimal.ZERO;

    @Column(name = "max_value", precision = 19, scale = 2)
    private BigDecimal maxValue;

    @Column(name = "no_max", nullable = false)
    private Boolean noMax = true;

    @Column(name = "price", nullable = false, precision = 19, scale = 2)
    private BigDecimal price = BigDecimal.ZERO;

    public String getShippingZone() {
        return shippingZone != null ? shippingZone.getId().toString() : null;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = WeightUnit.fromString(weightUnit);
    }

}
