package com.nguyenanhtu.exercise401.controller.request;

import lombok.Data;
import java.util.UUID;

@Data
public class CardRequest {
    private UUID customerId;
}