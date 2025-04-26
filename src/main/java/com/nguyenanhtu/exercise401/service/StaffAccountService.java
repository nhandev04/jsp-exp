package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Role;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StaffAccountService {

    private final List<StaffAccount> staffAccounts = new ArrayList<>();

    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccounts;
    }

    public StaffAccount createStaffAccount(StaffAccount staffAccount) {

        UUID roleId = UUID.fromString(staffAccount.getRole().toString()); // Convert the roleId string to UUID

        // Find the Role by ID
        Role role = Role.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Set the role to staffAccount
        staffAccount.setRole(role);

        // Add the staff account to the list (assuming it's an in-memory list)
        staffAccounts.add(staffAccount);
        return staffAccount;
    }
}