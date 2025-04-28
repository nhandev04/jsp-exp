package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.StaffAccountRequest;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.service.StaffAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/staff-accounts")
public class StaffAccountController {

    @Autowired
    private StaffAccountService staffAccountService;

    @GetMapping
    public ResponseEntity<List<StaffAccount>> getAllStaffAccounts() {
        List<StaffAccount> staffAccounts = staffAccountService.getAllStaffAccounts();
        return ResponseEntity.ok(staffAccounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffAccount> getStaffAccountById(@PathVariable UUID id) {
        return staffAccountService.getStaffAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StaffAccount> getStaffAccountByEmail(@PathVariable String email) {
        return staffAccountService.getStaffAccountByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StaffAccount> createStaffAccount(@RequestBody StaffAccountRequest request) {
        StaffAccount createdStaffAccount = staffAccountService.createStaffAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaffAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffAccount> updateStaffAccount(@PathVariable UUID id, @RequestBody StaffAccountRequest request) {
        try {
            StaffAccount updatedStaffAccount = staffAccountService.updateStaffAccount(id, request);
            return ResponseEntity.ok(updatedStaffAccount);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaffAccount(@PathVariable UUID id) {
        staffAccountService.deleteStaffAccount(id);
        return ResponseEntity.noContent().build();
    }
}
