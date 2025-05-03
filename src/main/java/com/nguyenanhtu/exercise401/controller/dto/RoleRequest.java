package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class RoleRequest {
    private UUID id;
    private String roleName;
    private String privileges;
}