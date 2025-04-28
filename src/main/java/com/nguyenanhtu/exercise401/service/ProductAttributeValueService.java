package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductAttributeValueService {
    List<ProductAttributeValue> getAllProductAttributeValues();
    
    Optional<ProductAttributeValue> getProductAttributeValueById(UUID id);
    
    List<ProductAttributeValue> getProductAttributeValuesByProductAttributeId(UUID productAttributeId);
    
    List<ProductAttributeValue> getProductAttributeValuesByAttributeValueId(UUID attributeValueId);
    
    List<ProductAttributeValue> getProductAttributeValuesByProductId(UUID productId);
    
    ProductAttributeValue addProductAttributeValue(ProductAttributeValue productAttributeValue);
    
    ProductAttributeValue updateProductAttributeValue(ProductAttributeValue productAttributeValue);
    
    void deleteProductAttributeValue(UUID id);
}