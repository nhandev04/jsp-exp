package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.RoleRequest;
import com.nguyenanhtu.exercise401.entity.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    List<Role> getAllRoles();
    
    Optional<Role> getRoleById(UUID id);

    Role createRole(RoleRequest request);
    
    Role updateRole(UUID id, RoleRequest request);
    
    void deleteRole(UUID id);
}
