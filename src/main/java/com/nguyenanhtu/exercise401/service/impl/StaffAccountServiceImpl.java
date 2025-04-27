package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.StaffAccountRequest;
import com.nguyenanhtu.exercise401.entity.Role;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.RoleRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.StaffAccountService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StaffAccountServiceImpl implements StaffAccountService {

    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccountRepository.findAll();
    }

    private final RoleRepository roleRepository;

    @Override
    public StaffAccount createStaffAccount(StaffAccountRequest request) {

        StaffAccount account = new StaffAccount();

        if (request.getRoleId() != null) {
            Role role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            account.setRoleId(role);
        }

        if (request.getCreatedBy() != null) {
            StaffAccount createdAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found"));
            account.setCreatedBy(createdAccount);

        }

        if (request.getUpdatedBy() != null) {
            StaffAccount updatedAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found"));

            account.setUpdatedBy(updatedAccount);
        }

        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setPasswordHash(request.getPasswordHash());
        account.setActive(request.getActive());
        account.setImage(request.getImage());
        account.setPlaceholder(request.getPlaceholder());

        StaffAccount createdStaffAccount = staffAccountRepository.save(account);
        return createdStaffAccount;
    }

    public StaffAccount findAccountById(UUID id) {
        return staffAccountRepository.findById(id).orElse(null);
    }
}
