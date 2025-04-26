package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.CustomerAdress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAdressRepository extends JpaRepository<CustomerAdress, Long> {
}