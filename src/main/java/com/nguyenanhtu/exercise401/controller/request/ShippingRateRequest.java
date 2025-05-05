package com.nguyenanhtu.exercise401.controller.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo.WeightUnit;

import lombok.Data;

@Data
public class ShippingRateRequest {
    private UUID id;
    private UUID shippingZoneId;
    private WeightUnit weightUnit;
    private BigDecimal minValue;
    private BigDecimal maxValue;
    private Boolean noMax;
    private BigDecimal price;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}