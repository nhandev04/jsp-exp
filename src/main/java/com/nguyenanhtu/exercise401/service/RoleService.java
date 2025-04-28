package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    List<Role> getAllRoles();

    Optional<Role> getRoleById(UUID id);

    Role addRole(Role role);

    Role updateRole(Role role);

    void deleteRole(UUID id);
}
