package com.nguyenanhtu.exercise401.controller.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CustomerAdressRequest {
    private String addressLine1;
    private String addressLine2;
    private String phoneNumber;
    private String dialCode;
    private String country;
    private String postalCode;
    private UUID customerId;
}