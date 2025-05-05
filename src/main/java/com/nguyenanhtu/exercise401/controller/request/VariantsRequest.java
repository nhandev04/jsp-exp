package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class VariantsRequest {
    private UUID id;
    private UUID productId;
    private UUID variantOptionId;

    private String sku;
    private String barcode;
    private String image;

    private Double price;
    private Double comparePrice;
    private Double costPrice;

    private Integer inventory;
}