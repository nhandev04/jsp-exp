package com.nguyenanhtu.exercise401.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductSuplierRequest {
    private UUID productId;
    private UUID supplierId;
    private BigDecimal price;
}