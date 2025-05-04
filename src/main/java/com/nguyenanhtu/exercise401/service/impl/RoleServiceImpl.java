package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.RoleRequest;
import com.nguyenanhtu.exercise401.entity.Role;
import com.nguyenanhtu.exercise401.repository.RoleRepository;
import com.nguyenanhtu.exercise401.service.RoleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(UUID id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role createRole(RoleRequest request) {
        Role role = new Role();
        return saveRole(role, request);
    }

    @Override
    public Role updateRole(UUID id, RoleRequest request) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        
        return saveRole(role, request);
    }

    @Override
    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }
    
    private Role saveRole(Role role, RoleRequest request) {
        // Set basic properties
        role.setRoleName(request.getRoleName());
        role.setPrivileges(request.getPrivileges());
        
        // Save and return the role
        return roleRepository.save(role);
    }
}
