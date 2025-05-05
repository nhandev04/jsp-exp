package com.nguyenanhtu.exercise401.controller.request;

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
    private UUID createdBy;
    private UUID updatedBy;

    public UUID getCreatedBy() {
        return createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }
}