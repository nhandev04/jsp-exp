package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class VariantValueRequest {
    private UUID id;
    private UUID variant;
    private UUID productAttributeValue;
    private UUID createdBy;
    private UUID updatedBy;
}