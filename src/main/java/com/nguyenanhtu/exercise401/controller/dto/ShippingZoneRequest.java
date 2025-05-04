package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class ShippingZoneRequest {
    private UUID id;
    private String name;
    private String displayName;
    private Boolean active;
    private Boolean freeShipping;
    private String rateType;
    private UUID createdById;
    private UUID updatedById;

    public UUID getCreatedBy() {
        return createdById;
    }

    public UUID getUpdatedBy() {
        return updatedById;
    }
}