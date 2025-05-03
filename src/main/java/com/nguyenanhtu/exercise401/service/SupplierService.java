package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.SupplierRequest;
import com.nguyenanhtu.exercise401.entity.Supplier;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierService {
    List<Supplier> getAllSuppliers();
    
    Optional<Supplier> getSupplierById(UUID id);

    Supplier addSupplier(SupplierRequest request);
    
    Supplier updateSupplier(UUID id, SupplierRequest request);
    
    void deleteSupplier(UUID id);
}