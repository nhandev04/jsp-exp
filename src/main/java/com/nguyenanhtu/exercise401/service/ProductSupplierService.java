package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.ProductSupplierRequest;
import com.nguyenanhtu.exercise401.entity.ProductSupplier;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductSupplierService {
    List<ProductSupplier> getAllProductSuppliers();
    
    Optional<ProductSupplier> getProductSupplierById(UUID id);
    
    List<ProductSupplier> getProductSuppliersByProductId(UUID productId);
    
    List<ProductSupplier> getProductSuppliersBySupplierId(UUID supplierId);

    ProductSupplier addProductSupplier(ProductSupplierRequest request);
    
    ProductSupplier updateProductSupplier(UUID id, ProductSupplierRequest request);
    
    void deleteProductSupplier(UUID id);
}