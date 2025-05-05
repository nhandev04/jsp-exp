package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.ProductSupplierRequest;
import com.nguyenanhtu.exercise401.entity.ProductSupplier;
import com.nguyenanhtu.exercise401.entity.ProductSupplier.ProductSupplierId;
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
    public Optional<ProductSupplier> getProductSupplierById(UUID productId, UUID supplierId) {
        ProductSupplierId id = new ProductSupplierId(productId, supplierId);
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
    public List<ProductSupplier> getPrimarySuppliersByProductId(UUID productId) {
        return productSupplierRepository.findPrimarySuppliersByProductId(productId);
    }

    @Override
    public ProductSupplier addProductSupplier(ProductSupplierRequest request) {
        // Create composite key
        ProductSupplierId id = new ProductSupplierId(request.getProductId(), request.getSupplierId());

        // Check if the product supplier already exists
        Optional<ProductSupplier> existingProductSupplier = productSupplierRepository.findById(id);

        if (existingProductSupplier.isPresent()) {
            return existingProductSupplier.get();
        }

        // Create a new product supplier
        ProductSupplier productSupplier = new ProductSupplier();
        productSupplier.setId(id);

        // Set product
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
        productSupplier.setProduct(product);

        // Set supplier
        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + request.getSupplierId()));
        productSupplier.setSupplier(supplier);

        // Save and return the product supplier
        return productSupplierRepository.save(productSupplier);
    }

    @Override
    public ProductSupplier updateProductSupplier(ProductSupplierRequest request) {
        // Create composite key
        ProductSupplierId id = new ProductSupplierId(request.getProductId(), request.getSupplierId());

        // Find existing record
        ProductSupplier productSupplier = productSupplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductSupplier not found with productId: " +
                        request.getProductId() + " and supplierId: " + request.getSupplierId()));

        return productSupplierRepository.save(productSupplier);
    }

    @Override
    public void deleteProductSupplier(UUID productId, UUID supplierId) {
        ProductSupplierId id = new ProductSupplierId(productId, supplierId);
        productSupplierRepository.deleteById(id);
    }
}