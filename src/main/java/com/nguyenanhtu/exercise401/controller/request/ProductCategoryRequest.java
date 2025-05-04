package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductCategoryRequest {
    private UUID id;
    private UUID productId;
    private UUID categoryId;
    private UUID createdById;
    private UUID updatedById;
}