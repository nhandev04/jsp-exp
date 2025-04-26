package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Role;
import com.nguyenanhtu.exercise401.repository.RoleRepository;
import com.nguyenanhtu.exercise401.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }
}