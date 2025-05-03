package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class CardRequest {
    private UUID id;
    private UUID customerId;
}