package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class AttributeValueRequest {
    private UUID id;
    private UUID attributeId;
    private String attributeValue;
    private String color;
}