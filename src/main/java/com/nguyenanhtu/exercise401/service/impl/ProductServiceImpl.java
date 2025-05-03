package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ProductRequest;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    @Override
    public Product addProduct(ProductRequest request) {
        Product product = new Product();
        return saveProduct(product, request);
    }

    @Override
    public Product updateProduct(UUID id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        return saveProduct(product, request);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
    
    private Product saveProduct(Product product, ProductRequest request) {
        // Set basic properties
        product.setSlug(request.getSlug());
        product.setProductName(request.getProductName());
        product.setSku(request.getSku());
        product.setSalePrice(request.getSalePrice());
        product.setComparePrice(request.getComparePrice());
        product.setBuyingPrice(request.getBuyingPrice());
        product.setQuantity(request.getQuantity());
        product.setShortDescription(request.getShortDescription());
        product.setProductDescription(request.getProductDescription());
        product.setProductType(request.getProductType());
        product.setPublished(request.getPublished());
        product.setDisableOutOfStock(request.getDisableOutOfStock());
        product.setNote(request.getNote());
        
        // Set createdBy if provided and this is a new product
        if (request.getCreatedBy() != null && product.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            product.setCreatedBy(createdByAccount);
        }
        
        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            product.setUpdatedBy(updatedByAccount);
        }
        
        // Save and return the product
        return productRepository.save(product);
    }
}