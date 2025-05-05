package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Supplier;
import com.nguyenanhtu.exercise401.controller.request.SupplierRequest;
import com.nguyenanhtu.exercise401.entity.Country;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.SupplierRepository;
import com.nguyenanhtu.exercise401.repository.CountryRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.SupplierService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final CountryRepository countryRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> getSupplierById(UUID id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Supplier addSupplier(SupplierRequest request) {
        Supplier supplier = new Supplier();
        return saveSupplier(supplier, request);
    }

    @Override
    public Supplier updateSupplier(UUID id, SupplierRequest request) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));

        return saveSupplier(supplier, request);
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierRepository.deleteById(id);
    }

    private Supplier saveSupplier(Supplier supplier, SupplierRequest request) {
        // Set basic properties
        if (request.getSupplierName() != null) {
            supplier.setSupplierName(request.getSupplierName());
        }
        if (request.getCompany() != null) {
            supplier.setCompany(request.getCompany());
        }
        if (request.getPhoneNumber() != null) {
            supplier.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getAddressLine1() != null) {
            supplier.setAddressLine1(request.getAddressLine1());
        }
        if (request.getAddressLine2() != null) {
            supplier.setAddressLine2(request.getAddressLine2());
        }
        if (request.getCity() != null) {
            supplier.setCity(request.getCity());
        }
        if (request.getNote() != null) {
            supplier.setNote(request.getNote());
        }
        // Set country if provided
        if (request.getCountryId() != null) {
            Country country = countryRepository.findById(request.getCountryId())
                    .orElseThrow(() -> new RuntimeException("Country not found with id: " + request.getCountryId()));
            supplier.setCountry(country);
        }

        // Set createdBy if provided and this is a new supplier
        if (request.getCreatedBy() != null && supplier.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            supplier.setCreatedBy(createdByAccount);
        }

        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            supplier.setUpdatedBy(updatedByAccount);
        }

        // Save and return the supplier
        return supplierRepository.save(supplier);
    }
}