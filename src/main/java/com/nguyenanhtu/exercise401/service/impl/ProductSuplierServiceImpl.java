package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ProductSuplierRequest;
import com.nguyenanhtu.exercise401.entity.ProductSuplier;
import com.nguyenanhtu.exercise401.entity.ProductSuplier.ProductSuplierId;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.ProductSuplierRepository;
import com.nguyenanhtu.exercise401.repository.SupplierRepository;
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
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

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
    public ProductSuplier addProductSuplier(ProductSuplierRequest request) {
        // Verify that both product and supplier exist
        productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));

        supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + request.getSupplierId()));

        // Create the relationship entity
        ProductSuplier productSuplier = new ProductSuplier();
        productSuplier.setId(new ProductSuplierId(request.getProductId(), request.getSupplierId()));
        
        // Note: Price is not stored in ProductSuplier entity based on current definition
        // If price needs to be stored, the entity needs to be updated to include a price field
        
        return productSuplierRepository.save(productSuplier);
    }

    @Override
    public ProductSuplier updateProductSuplier(ProductSuplierId id, ProductSuplierRequest request) {
        // Check if the relationship exists
        ProductSuplier productSuplier = productSuplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product supplier relationship not found with id: " + id));
        
        // Note: Currently there's no price field to update in the ProductSuplier entity
        // If more fields are added to the entity in the future, update them here
        
        return productSuplier; // Simply return the existing entity as there's nothing to update
    }

    @Override
    public void deleteProductSuplier(ProductSuplierId id) {
        productSuplierRepository.deleteById(id);
    }
}