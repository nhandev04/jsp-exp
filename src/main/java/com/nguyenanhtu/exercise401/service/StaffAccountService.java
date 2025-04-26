package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffAccountService {

    @Autowired
    private StaffAccountRepository staffAccountRepository;

    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccountRepository.findAll();
    }

    public StaffAccount createStaffAccount(StaffAccount staffAccount) {
        return staffAccountRepository.save(staffAccount);
    }
}