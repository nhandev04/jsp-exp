package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeValueRequest {
    private UUID id;
    private UUID attributeId;
    private String attributeValue;
    private String color;
}