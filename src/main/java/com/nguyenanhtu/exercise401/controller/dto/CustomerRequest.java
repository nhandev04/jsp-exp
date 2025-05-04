package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class CustomerRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean active;
}