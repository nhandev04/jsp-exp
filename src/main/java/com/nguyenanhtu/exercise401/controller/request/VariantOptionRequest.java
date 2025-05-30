package com.nguyenanhtu.exercise401.controller.request;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class VariantOptionRequest {
    private UUID id;
    private String title;
    private UUID imageId;
    private UUID productId;
    private BigDecimal salePrice;
    private BigDecimal comparePrice;
    private BigDecimal buyingPrice;
    private Integer quantity;
    private String sku;
    private Boolean active;
    private UUID variantId;
}