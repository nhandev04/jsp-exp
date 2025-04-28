package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductAttribute;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductAttributeService {
    List<ProductAttribute> getAllProductAttributes();
    
    Optional<ProductAttribute> getProductAttributeById(UUID id);
    
    List<ProductAttribute> getProductAttributesByProductId(UUID productId);
    
    List<ProductAttribute> getProductAttributesByAttributeId(UUID attributeId);
    
    ProductAttribute addProductAttribute(ProductAttribute productAttribute);
    
    ProductAttribute updateProductAttribute(ProductAttribute productAttribute);
    
    void deleteProductAttribute(UUID id);
}