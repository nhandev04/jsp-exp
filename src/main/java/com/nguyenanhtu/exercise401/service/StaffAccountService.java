package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.StaffAccountRequest;
import com.nguyenanhtu.exercise401.entity.StaffAccount;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StaffAccountService {
    List<StaffAccount> getAllStaffAccounts();

    Optional<StaffAccount> getStaffAccountById(UUID id);

    Optional<StaffAccount> getStaffAccountByEmail(String email);

    StaffAccount createStaffAccount(StaffAccountRequest request);

    StaffAccount updateStaffAccount(UUID id, StaffAccountRequest request);

    void deleteStaffAccount(UUID id);
}
