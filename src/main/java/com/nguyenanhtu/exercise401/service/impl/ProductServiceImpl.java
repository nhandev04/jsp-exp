package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.ProductRequest;
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
        if (request.getSlug() != null) {
            product.setSlug(request.getSlug());
        }
        if (request.getProductName() != null) {
            product.setProductName(request.getProductName());
        }
        if (request.getSku() != null) {
            product.setSku(request.getSku());
        }
        if (request.getSalePrice() != null) {
            product.setSalePrice(request.getSalePrice());
        }
        if (request.getComparePrice() != null) {
            product.setComparePrice(request.getComparePrice());
        }
        if (request.getBuyingPrice() != null) {
            product.setBuyingPrice(request.getBuyingPrice());
        }
        if (request.getQuantity() != null) {
            product.setQuantity(request.getQuantity());
        }
        if (request.getShortDescription() != null) {
            product.setShortDescription(request.getShortDescription());
        }
        if (request.getProductDescription() != null) {
            product.setProductDescription(request.getProductDescription());
        }

        // Convert String to ProductType enum
        if (request.getProductType() != null) {
            product.setProductType(Product.ProductType.valueOf(request.getProductType()));
        }

        if (request.getPublished() != null) {
            product.setPublished(request.getPublished());
        }
        if (request.getDisableOutOfStock() != null) {
            product.setDisableOutOfStock(request.getDisableOutOfStock());
        }
        if (request.getNote() != null) {
            product.setNote(request.getNote());
        }

        // Set createdBy if provided and this is a new product
        if (request.getCreatedBy() != null && product.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            product.setCreatedBy(createdByAccount);
        }

        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            product.setUpdatedBy(updatedByAccount);
        }

        // Save and return the product
        return productRepository.save(product);
    }
}