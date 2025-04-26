package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private final List<Role> roles = new ArrayList<>();

    public List<Role> getAllRoles() {
        return roles;
    }

    public Role addRole(Role role) {
        roles.add(role);
        return role;
    }
}