package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.StaffAccount;
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

    @Override
    public StaffAccount createStaffAccount(StaffAccount staffAccount) {

        return staffAccountRepository.save(staffAccount);
    }
}