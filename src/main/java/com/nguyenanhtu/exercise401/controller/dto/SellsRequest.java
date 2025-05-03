package com.nguyenanhtu.exercise401.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class SellsRequest {
    private UUID id;
    private UUID productId;
    private BigDecimal price;
    private Integer quantity;
}