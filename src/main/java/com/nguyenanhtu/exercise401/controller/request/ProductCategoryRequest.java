package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductCategoryRequest {
    private UUID id;
    private UUID product;
    private UUID category;
    private UUID createdBy;
    private UUID updatedBy;
}