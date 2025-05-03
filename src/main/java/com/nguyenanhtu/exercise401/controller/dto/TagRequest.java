package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class TagRequest {
    private UUID id;
    private String tagName;
    private String icon;
    private UUID createdById;
    private UUID updatedById;
}