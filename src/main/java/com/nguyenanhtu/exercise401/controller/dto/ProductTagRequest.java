package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductTagRequest {
    private UUID productId;
    private UUID tagId;
}