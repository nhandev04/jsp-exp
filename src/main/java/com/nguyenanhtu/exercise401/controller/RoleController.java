package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.Role;
import com.nguyenanhtu.exercise401.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role createdRole = roleService.addRole(role);
        return ResponseEntity.ok(createdRole);
    }
}