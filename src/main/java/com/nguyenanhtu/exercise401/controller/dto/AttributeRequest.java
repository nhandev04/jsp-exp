package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class AttributeRequest {
    private UUID id;
    private String attributeName;
    private UUID createdById;
    private UUID updatedById;
}