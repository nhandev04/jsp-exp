package com.nguyenanhtu.exercise401.controller.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CouponRequest {
    private String code;
    private String type;
    private Double value;
    private Double minOrderAmount;
    private Integer maxUses;
    private Integer usesCount;
    private LocalDateTime expiryDate;
    private Boolean active;
}