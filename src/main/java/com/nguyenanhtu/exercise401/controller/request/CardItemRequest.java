package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class CardItemRequest {
    private UUID id;
    private UUID cardId;
    private UUID productId;
    private Integer quantity;
}