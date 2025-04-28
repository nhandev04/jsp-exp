package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductSuplier;
import com.nguyenanhtu.exercise401.entity.ProductSuplier.ProductSuplierId;
import com.nguyenanhtu.exercise401.repository.ProductSuplierRepository;
import com.nguyenanhtu.exercise401.service.ProductSuplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductSuplierServiceImpl implements ProductSuplierService {

    private final ProductSuplierRepository productSuplierRepository;

    @Override
    public List<ProductSuplier> getAllProductSupliers() {
        return productSuplierRepository.findAll();
    }

    @Override
    public Optional<ProductSuplier> getProductSuplierById(ProductSuplierId id) {
        return productSuplierRepository.findById(id);
    }

    @Override
    public List<ProductSuplier> getProductSupliersByProductId(UUID productId) {
        return productSuplierRepository.findByProductId(productId);
    }

    @Override
    public List<ProductSuplier> getProductSupliersBySupplierId(UUID supplierId) {
        return productSuplierRepository.findBySupplierId(supplierId);
    }

    @Override
    public ProductSuplier addProductSuplier(ProductSuplier productSuplier) {
        return productSuplierRepository.save(productSuplier);
    }

    @Override
    public ProductSuplier updateProductSuplier(ProductSuplier productSuplier) {
        return productSuplierRepository.save(productSuplier);
    }

    @Override
    public void deleteProductSuplier(ProductSuplierId id) {
        productSuplierRepository.deleteById(id);
    }
}