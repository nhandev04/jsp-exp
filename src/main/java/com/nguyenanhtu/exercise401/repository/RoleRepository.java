package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}