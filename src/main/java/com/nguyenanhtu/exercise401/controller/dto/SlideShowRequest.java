package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class SlideShowRequest {
    private UUID id;
    private String title;
    private String destinationUrl;
    private String image;
    private String placeholder;
    private String description;
    private String btnLabel;
    private Integer displayOrder;
    private Boolean published;
    private Integer clicks;
    private String styles;
    private UUID createdById;
    private UUID updatedById;

    public UUID getCreatedBy() {
        return createdById;
    }

    public UUID getUpdatedBy() {
        return updatedById;
    }
}