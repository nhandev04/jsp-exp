package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import com.nguyenanhtu.exercise401.entity.ProductAttribute;
import com.nguyenanhtu.exercise401.controller.request.ProductAttributeValueRequest;
import com.nguyenanhtu.exercise401.entity.AttributeValue;
import com.nguyenanhtu.exercise401.repository.ProductAttributeValueRepository;
import com.nguyenanhtu.exercise401.repository.ProductAttributeRepository;
import com.nguyenanhtu.exercise401.repository.AttributeValueRepository;
import com.nguyenanhtu.exercise401.service.ProductAttributeValueService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {

    private final ProductAttributeValueRepository productAttributeValueRepository;
    private final ProductAttributeRepository productAttributeRepository;
    private final AttributeValueRepository attributeValueRepository;

    @Override
    public List<ProductAttributeValue> getAllProductAttributeValues() {
        return productAttributeValueRepository.findAll();
    }

    @Override
    public Optional<ProductAttributeValue> getProductAttributeValueById(UUID id) {
        return productAttributeValueRepository.findById(id);
    }
    
    @Override
    public List<ProductAttributeValue> getProductAttributeValuesByProductId(UUID productId) {
        return productAttributeValueRepository.findByProductId(productId);
    }
    
    @Override
    public List<ProductAttributeValue> getProductAttributeValuesByAttributeValueId(UUID attributeValueId) {
        return productAttributeValueRepository.findByAttributeValueId(attributeValueId);
    }

    @Override
    public List<ProductAttributeValue> getProductAttributeValuesByProductAttributeId(UUID productAttributeId) {
        return productAttributeValueRepository.findByProductAttributeId(productAttributeId);
    }

    @Override
    public ProductAttributeValue addProductAttributeValue(ProductAttributeValueRequest request) {
        ProductAttributeValue productAttributeValue = new ProductAttributeValue();
        return saveProductAttributeValue(productAttributeValue, request);
    }

    @Override
    public ProductAttributeValue updateProductAttributeValue(UUID id, ProductAttributeValueRequest request) {
        ProductAttributeValue productAttributeValue = productAttributeValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product attribute value not found with id: " + id));
        
        return saveProductAttributeValue(productAttributeValue, request);
    }

    @Override
    public void deleteProductAttributeValue(UUID id) {
        productAttributeValueRepository.deleteById(id);
    }
    
    private ProductAttributeValue saveProductAttributeValue(ProductAttributeValue productAttributeValue, ProductAttributeValueRequest request) {
        // Set product attribute if provided
        if (request.getProductAttributeId() != null) {
            ProductAttribute productAttribute = productAttributeRepository.findById(request.getProductAttributeId())
                    .orElseThrow(() -> new RuntimeException("Product attribute not found with id: " + request.getProductAttributeId()));
            productAttributeValue.setProductAttribute(productAttribute);
        }
        
        // Set attribute value if provided
        if (request.getAttributeValueId() != null) {
            AttributeValue attributeValue = attributeValueRepository.findById(request.getAttributeValueId())
                    .orElseThrow(() -> new RuntimeException("Attribute value not found with id: " + request.getAttributeValueId()));
            productAttributeValue.setAttributeValue(attributeValue);
        }
        
        // Save and return the product attribute value
        return productAttributeValueRepository.save(productAttributeValue);
    }
}