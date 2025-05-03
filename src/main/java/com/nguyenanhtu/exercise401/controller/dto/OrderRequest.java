package com.nguyenanhtu.exercise401.controller.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderRequest {
    private String id;
    private String couponId;
    private String customerId;
    private String orderStatusId;
    private LocalDateTime orderApprovedAt;
    private LocalDateTime orderDeliveredCarrierDate;
    private LocalDateTime orderDeliveredCustomerDate;
}