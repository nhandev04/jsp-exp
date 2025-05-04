package com.nguyenanhtu.exercise401.controller.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CardRequest {
    private UUID customerId;
}