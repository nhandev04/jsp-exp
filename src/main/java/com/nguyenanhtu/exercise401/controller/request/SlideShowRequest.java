package com.nguyenanhtu.exercise401.controller.request;

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
    private UUID createdBy;
    private UUID updatedBy;

    public UUID getCreatedBy() {
        return createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }
}