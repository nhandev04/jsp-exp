package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductSupplierRequest {
    private UUID productId;
    private UUID supplierId;
}