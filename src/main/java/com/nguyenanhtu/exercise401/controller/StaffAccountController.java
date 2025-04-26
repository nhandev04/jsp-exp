package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.StaffAccountRequest;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.service.StaffAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<StaffAccount> createStaffAccount(@RequestBody StaffAccountRequest request) {
        StaffAccount createdStaffAccount = staffAccountService.createStaffAccount(request);
        return ResponseEntity.ok(createdStaffAccount);
    }
}