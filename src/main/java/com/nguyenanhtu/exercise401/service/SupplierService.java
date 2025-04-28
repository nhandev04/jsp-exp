package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Supplier;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierService {
    List<Supplier> getAllSuppliers();
    
    Optional<Supplier> getSupplierById(UUID id);
    
    Supplier addSupplier(Supplier supplier);
    
    Supplier updateSupplier(Supplier supplier);
    
    void deleteSupplier(UUID id);
}