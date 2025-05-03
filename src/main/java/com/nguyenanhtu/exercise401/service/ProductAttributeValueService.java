package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.ProductAttributeValueRequest;
import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductAttributeValueService {
    List<ProductAttributeValue> getAllProductAttributeValues();
    
    Optional<ProductAttributeValue> getProductAttributeValueById(UUID id);
    
    List<ProductAttributeValue> getProductAttributeValuesByProductAttributeId(UUID productAttributeId);
    
    List<ProductAttributeValue> getProductAttributeValuesByProductId(UUID productId);
    
    List<ProductAttributeValue> getProductAttributeValuesByAttributeValueId(UUID attributeValueId);

    ProductAttributeValue addProductAttributeValue(ProductAttributeValueRequest request);
    
    ProductAttributeValue updateProductAttributeValue(UUID id, ProductAttributeValueRequest request);
    
    void deleteProductAttributeValue(UUID id);
}