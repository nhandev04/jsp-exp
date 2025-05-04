package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductAttribute;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.controller.request.ProductAttributeRequest;
import com.nguyenanhtu.exercise401.entity.Attribute;
import com.nguyenanhtu.exercise401.repository.ProductAttributeRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.AttributeRepository;
import com.nguyenanhtu.exercise401.service.ProductAttributeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;
    private final ProductRepository productRepository;
    private final AttributeRepository attributeRepository;

    @Override
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeRepository.findAll();
    }

    @Override
    public Optional<ProductAttribute> getProductAttributeById(UUID id) {
        return productAttributeRepository.findById(id);
    }
    
    @Override
    public List<ProductAttribute> getProductAttributesByProductId(UUID productId) {
        return productAttributeRepository.findByProductId(productId);
    }
    
    @Override
    public List<ProductAttribute> getProductAttributesByAttributeId(UUID attributeId) {
        return productAttributeRepository.findByAttributeId(attributeId);
    }

    @Override
    public ProductAttribute addProductAttribute(ProductAttributeRequest request) {
        ProductAttribute productAttribute = new ProductAttribute();
        return saveProductAttribute(productAttribute, request);
    }

    @Override
    public ProductAttribute updateProductAttribute(UUID id, ProductAttributeRequest request) {
        ProductAttribute productAttribute = productAttributeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product attribute not found with id: " + id));
        
        return saveProductAttribute(productAttribute, request);
    }

    @Override
    public void deleteProductAttribute(UUID id) {
        productAttributeRepository.deleteById(id);
    }
    
    private ProductAttribute saveProductAttribute(ProductAttribute productAttribute, ProductAttributeRequest request) {
        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            productAttribute.setProduct(product);
        }
        
        // Set attribute if provided
        if (request.getAttributeId() != null) {
            Attribute attribute = attributeRepository.findById(request.getAttributeId())
                    .orElseThrow(() -> new RuntimeException("Attribute not found with id: " + request.getAttributeId()));
            productAttribute.setAttribute(attribute);
        }
        
        // Save and return the product attribute
        return productAttributeRepository.save(productAttribute);
    }
}