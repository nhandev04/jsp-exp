package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductSuplier;
import com.nguyenanhtu.exercise401.entity.ProductSuplier.ProductSuplierId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductSuplierService {
    List<ProductSuplier> getAllProductSupliers();
    
    Optional<ProductSuplier> getProductSuplierById(ProductSuplierId id);
    
    List<ProductSuplier> getProductSupliersByProductId(UUID productId);
    
    List<ProductSuplier> getProductSupliersBySupplierId(UUID supplierId);
    
    ProductSuplier addProductSuplier(ProductSuplier productSuplier);
    
    ProductSuplier updateProductSuplier(ProductSuplier productSuplier);
    
    void deleteProductSuplier(ProductSuplierId id);
}