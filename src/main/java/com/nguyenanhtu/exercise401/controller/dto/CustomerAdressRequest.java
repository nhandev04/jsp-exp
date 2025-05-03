package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class CustomerAdressRequest {
    private UUID id;
    private UUID customerId;
    private String addressLine1;
    private String addressLine2;
    private String phoneNumber;
    private String dialCode;
    private String country;
    private String postalCode;
    private String city;
}