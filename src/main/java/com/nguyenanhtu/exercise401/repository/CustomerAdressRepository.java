package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.CustomerAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerAdressRepository extends JpaRepository<CustomerAdress, UUID> {
    @Query("SELECT ca FROM CustomerAdress ca WHERE ca.customer.id = :customerId")
    List<CustomerAdress> findByCustomerId(@Param("customerId") UUID customerId);
}
