package com.nguyenanhtu.exercise401.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductShippingInfoRequest {
    private UUID id;
    private UUID productId;
    private BigDecimal weight;
    private String weightUnit;
    private BigDecimal volume;
    private String volumeUnit;
    private BigDecimal dimensionWidth;
    private BigDecimal dimensionHeight;
    private BigDecimal dimensionDepth;
    private String dimensionUnit;
}