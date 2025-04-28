package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductAttribute;
import com.nguyenanhtu.exercise401.repository.ProductAttributeRepository;
import com.nguyenanhtu.exercise401.service.ProductAttributeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;

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
    public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    @Override
    public ProductAttribute updateProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    @Override
    public void deleteProductAttribute(UUID id) {
        productAttributeRepository.deleteById(id);
    }
}