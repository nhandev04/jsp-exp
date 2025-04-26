package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role addRole(Role role);

    Role updateRole(Role role);
}