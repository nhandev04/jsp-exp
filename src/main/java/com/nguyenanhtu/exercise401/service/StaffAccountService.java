package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.controller.dto.StaffAccountRequest;
import java.util.List;

public interface StaffAccountService {
    List<StaffAccount> getAllStaffAccounts();

    StaffAccount createStaffAccount(StaffAccountRequest request);
}