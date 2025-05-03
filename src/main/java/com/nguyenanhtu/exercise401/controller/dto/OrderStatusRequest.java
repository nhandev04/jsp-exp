package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class OrderStatusRequest {
    private UUID id;
    private String statusName;
    private String color;
    private String privacy;
    private UUID createdById;
    private UUID updatedById;
}