package com.nguyenanhtu.exercise401.controller.request;

import java.util.UUID;

import lombok.Data;

@Data
public class StaffAccountRequest {
    private UUID roleId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Boolean active;
    private String image;
    private String placeholder;
    private UUID createdBy;
    private UUID updatedBy;
}