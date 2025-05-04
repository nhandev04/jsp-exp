package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductCouponRequest {
    private UUID id;
    private UUID productId;
    private UUID couponId;
}