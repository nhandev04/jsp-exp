package com.nguyenanhtu.exercise401.controller.request;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderItemRequest {
    private UUID id;
    private UUID productId;
    private String orderId;
    private BigDecimal price;
    private Integer quantity;
}