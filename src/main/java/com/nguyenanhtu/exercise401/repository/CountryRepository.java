package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
