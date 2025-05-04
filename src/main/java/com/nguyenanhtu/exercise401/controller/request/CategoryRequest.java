package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class CategoryRequest {
    private UUID id;
    private UUID parentId;
    private String categoryName;
    private String categoryDescription;
    private String icon;
    private String image;
    private String placeholder;
    private Boolean active;
    private UUID createdBy;
    private UUID updatedBy;
}