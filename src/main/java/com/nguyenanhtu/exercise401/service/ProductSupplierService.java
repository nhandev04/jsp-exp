package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.ProductSupplierRequest;
import com.nguyenanhtu.exercise401.entity.ProductSupplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductSupplierService {
    List<ProductSupplier> getAllProductSuppliers();

    Optional<ProductSupplier> getProductSupplierById(UUID productId, UUID supplierId);

    List<ProductSupplier> getProductSuppliersByProductId(UUID productId);

    List<ProductSupplier> getProductSuppliersBySupplierId(UUID supplierId);

    List<ProductSupplier> getPrimarySuppliersByProductId(UUID productId);

    ProductSupplier addProductSupplier(ProductSupplierRequest request);

    ProductSupplier updateProductSupplier(ProductSupplierRequest request);

    void deleteProductSupplier(UUID productId, UUID supplierId);
}