package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class VariantsRequest {
    private UUID id;
    private UUID productId;
    private UUID variantOptionId;
}