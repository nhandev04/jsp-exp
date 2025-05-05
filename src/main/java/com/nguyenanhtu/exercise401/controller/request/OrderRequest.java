package com.nguyenanhtu.exercise401.controller.request;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderRequest {
    private UUID id;
    private UUID customerId;
    private UUID couponId;
    private UUID orderStatusId;
    private LocalDateTime orderApprovedAt;
    private LocalDateTime orderDeliveredCarrierDate;
    private LocalDateTime orderDeliveredCustomerDate;
}