package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class AttributeRequest {
    private UUID id;
    private String attributeName;
    private UUID createdBy;
    private UUID updatedBy;
}