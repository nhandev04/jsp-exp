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
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        StaffAccount account = new StaffAccount();

        account.setFirstName(request.getFirstName());
        account.setRoleId(role);
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
}
