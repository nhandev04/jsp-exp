package com.nguyenanhtu.exercise401.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ShippingRateRequest {
    private UUID id;
    private UUID shippingZoneId;
    private String weightUnit;
    private BigDecimal minValue;
    private BigDecimal maxValue;
    private Boolean noMax;
    private BigDecimal price;
}