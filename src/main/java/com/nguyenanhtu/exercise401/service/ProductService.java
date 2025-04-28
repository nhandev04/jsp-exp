package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    
    Optional<Product> getProductById(UUID id);
    
    Optional<Product> getProductBySlug(String slug);
    
    Product addProduct(Product product);
    
    Product updateProduct(Product product);
    
    void deleteProduct(UUID id);
}