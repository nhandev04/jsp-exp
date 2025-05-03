package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductAttributeValueRequest {
    private UUID id;
    private UUID productAttributeId;
    private UUID attributeValueId;
}