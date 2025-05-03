package com.nguyenanhtu.exercise401.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class CouponRequest {
    private UUID id;
    private String code;
    private BigDecimal discountValue;
    private String discountType;
    private BigDecimal timesUsed;
    private BigDecimal maxUsage;
    private BigDecimal orderAmountLimit;
    private LocalDateTime couponStartDate;
    private LocalDateTime couponEndDate;
}