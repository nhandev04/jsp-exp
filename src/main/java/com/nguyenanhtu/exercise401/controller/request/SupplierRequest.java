package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class SupplierRequest {
    private UUID id;
    private String supplierName;
    private String company;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private UUID countryId;
    private String city;
    private String note;
    private UUID createdById;
    private UUID updatedById;

    public UUID getCreatedBy() {
        return createdById;
    }

    public UUID getUpdatedBy() {
        return updatedById;
    }
}