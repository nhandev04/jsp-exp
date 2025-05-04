package com.nguyenanhtu.exercise401.controller.request;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductRequest {
    private UUID id;
    private String slug;
    private String productName;
    private String sku;
    private BigDecimal salePrice;
    private BigDecimal comparePrice;
    private BigDecimal buyingPrice;
    private Integer quantity;
    private String shortDescription;
    private String productDescription;
    private String productType;
    private Boolean published;
    private Boolean disableOutOfStock;
    private String note;
    private UUID createdById;
    private UUID updatedById;
}