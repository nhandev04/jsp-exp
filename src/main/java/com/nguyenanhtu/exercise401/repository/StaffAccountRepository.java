package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.StaffAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffAccountRepository extends JpaRepository<StaffAccount, Long> {
}