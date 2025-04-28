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
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StaffAccountServiceImpl implements StaffAccountService {

    private final StaffAccountRepository staffAccountRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccountRepository.findAll();
    }

    @Override
    public Optional<StaffAccount> getStaffAccountById(UUID id) {
        return staffAccountRepository.findById(id);
    }

    @Override
    public Optional<StaffAccount> getStaffAccountByEmail(String email) {
        return staffAccountRepository.findByEmail(email);
    }

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

        return staffAccountRepository.save(account);
    }

    @Override
    public StaffAccount updateStaffAccount(UUID id, StaffAccountRequest request) {
        StaffAccount account = staffAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + id));

        if (request.getRoleId() != null) {
            Role role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            account.setRoleId(role);
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

        return staffAccountRepository.save(account);
    }

    @Override
    public void deleteStaffAccount(UUID id) {
        staffAccountRepository.deleteById(id);
    }
}
