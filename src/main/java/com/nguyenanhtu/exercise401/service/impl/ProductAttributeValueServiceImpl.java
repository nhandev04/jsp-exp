package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import com.nguyenanhtu.exercise401.repository.ProductAttributeValueRepository;
import com.nguyenanhtu.exercise401.service.ProductAttributeValueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {

    private final ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public List<ProductAttributeValue> getAllProductAttributeValues() {
        return productAttributeValueRepository.findAll();
    }

    @Override
    public Optional<ProductAttributeValue> getProductAttributeValueById(UUID id) {
        return productAttributeValueRepository.findById(id);
    }

    @Override
    public List<ProductAttributeValue> getProductAttributeValuesByProductAttributeId(UUID productAttributeId) {
        return productAttributeValueRepository.findByProductAttributeId(productAttributeId);
    }

    @Override
    public List<ProductAttributeValue> getProductAttributeValuesByAttributeValueId(UUID attributeValueId) {
        return productAttributeValueRepository.findByAttributeValueId(attributeValueId);
    }

    @Override
    public List<ProductAttributeValue> getProductAttributeValuesByProductId(UUID productId) {
        return productAttributeValueRepository.findByProductId(productId);
    }

    @Override
    public ProductAttributeValue addProductAttributeValue(ProductAttributeValue productAttributeValue) {
        return productAttributeValueRepository.save(productAttributeValue);
    }

    @Override
    public ProductAttributeValue updateProductAttributeValue(ProductAttributeValue productAttributeValue) {
        return productAttributeValueRepository.save(productAttributeValue);
    }

    @Override
    public void deleteProductAttributeValue(UUID id) {
        productAttributeValueRepository.deleteById(id);
    }
}