package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ProductSupplierRequest;
import com.nguyenanhtu.exercise401.entity.ProductSupplier;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.entity.Supplier;
import com.nguyenanhtu.exercise401.repository.ProductSupplierRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.SupplierRepository;
import com.nguyenanhtu.exercise401.service.ProductSupplierService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductSupplierServiceImpl implements ProductSupplierService {

    private final ProductSupplierRepository productSupplierRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public List<ProductSupplier> getAllProductSuppliers() {
        return productSupplierRepository.findAll();
    }

    @Override
    public Optional<ProductSupplier> getProductSupplierById(UUID id) {
        return productSupplierRepository.findById(id);
    }
    
    @Override
    public List<ProductSupplier> getProductSuppliersByProductId(UUID productId) {
        return productSupplierRepository.findByProductId(productId);
    }
    
    @Override
    public List<ProductSupplier> getProductSuppliersBySupplierId(UUID supplierId) {
        return productSupplierRepository.findBySupplierId(supplierId);
    }

    @Override
    public ProductSupplier addProductSupplier(ProductSupplierRequest request) {
        ProductSupplier productSupplier = new ProductSupplier();
        return saveProductSupplier(productSupplier, request);
    }

    @Override
    public ProductSupplier updateProductSupplier(UUID id, ProductSupplierRequest request) {
        ProductSupplier productSupplier = productSupplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product supplier not found with id: " + id));
        
        return saveProductSupplier(productSupplier, request);
    }

    @Override
    public void deleteProductSupplier(UUID id) {
        productSupplierRepository.deleteById(id);
    }
    
    private ProductSupplier saveProductSupplier(ProductSupplier productSupplier, ProductSupplierRequest request) {
        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            productSupplier.setProduct(product);
        }
        
        // Set supplier if provided
        if (request.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(request.getSupplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + request.getSupplierId()));
            productSupplier.setSupplier(supplier);
        }
        
        // Set additional properties
        productSupplier.setNote(request.getNote());
        productSupplier.setPreferredSupplier(request.getPreferredSupplier());
        
        // Save and return the product supplier
        return productSupplierRepository.save(productSupplier);
    }
}