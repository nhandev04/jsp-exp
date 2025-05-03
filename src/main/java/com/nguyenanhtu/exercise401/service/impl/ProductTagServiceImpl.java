package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ProductTagRequest;
import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.entity.Tag;
import com.nguyenanhtu.exercise401.repository.ProductTagRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.TagRepository;
import com.nguyenanhtu.exercise401.service.ProductTagService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductTagServiceImpl implements ProductTagService {

    private final ProductTagRepository productTagRepository;
    private final ProductRepository productRepository;
    private final TagRepository tagRepository;

    @Override
    public List<ProductTag> getAllProductTags() {
        return productTagRepository.findAll();
    }

    @Override
    public Optional<ProductTag> getProductTagById(UUID productId, UUID tagId) {
        return productTagRepository.findByProductIdAndTagId(productId, tagId);
    }
    
    @Override
    public List<ProductTag> getProductTagsByProductId(UUID productId) {
        return productTagRepository.findByProductId(productId);
    }
    
    @Override
    public List<ProductTag> getProductTagsByTagId(UUID tagId) {
        return productTagRepository.findByTagId(tagId);
    }

    @Override
    public ProductTag addProductTag(ProductTagRequest request) {
        // Check if the product tag already exists
        Optional<ProductTag> existingProductTag = productTagRepository.findByProductIdAndTagId(
                request.getProductId(), request.getTagId());
        
        if (existingProductTag.isPresent()) {
            return existingProductTag.get();
        }
        
        // Create a new product tag
        ProductTag productTag = new ProductTag();
        
        // Set product
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
        productTag.setProduct(product);
        
        // Set tag
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + request.getTagId()));
        productTag.setTag(tag);
        
        // Save and return the product tag
        return productTagRepository.save(productTag);
    }

    @Override
    public void deleteProductTag(UUID productId, UUID tagId) {
        productTagRepository.deleteByProductIdAndTagId(productId, tagId);
    }
}