package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.StaffAccount;
import java.util.List;

public interface StaffAccountService {
    List<StaffAccount> getAllStaffAccounts();

    StaffAccount createStaffAccount(StaffAccount staffAccount);
}