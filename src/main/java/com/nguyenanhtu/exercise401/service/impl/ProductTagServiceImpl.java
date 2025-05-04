package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ProductTagRequest;
import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.entity.ProductTag.ProductTagId;
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

    @Override
    public List<ProductTag> getAllProductTags() {
        return productTagRepository.findAll();
    }

    @Override
    public Optional<ProductTag> getProductTagById(UUID productId, UUID tagId) {
        ProductTagId id = new ProductTagId(productId, tagId);
        return productTagRepository.findById(id);
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
        // Create composite key
        ProductTagId id = new ProductTagId(request.getProductId(), request.getTagId());
        
        // Check if the product tag already exists
        Optional<ProductTag> existingProductTag = productTagRepository.findById(id);
        
        if (existingProductTag.isPresent()) {
            return existingProductTag.get();
        }
        
        // Create a new product tag
        ProductTag productTag = new ProductTag();
        productTag.setId(id);
        
        // Save and return the product tag
        return productTagRepository.save(productTag);
    }

    @Override
    public ProductTag updateProductTag(ProductTagRequest request) {
        // Create composite key
        ProductTagId id = new ProductTagId(request.getProductId(), request.getTagId());
        
        Optional<ProductTag> existingProductTag = productTagRepository.findById(id);
        
        if (!existingProductTag.isPresent()) {
            throw new RuntimeException("ProductTag not found");
        }
        
        return existingProductTag.get();
    }

    @Override
    public void deleteProductTag(UUID productId, UUID tagId) {
        ProductTagId id = new ProductTagId(productId, tagId);
        productTagRepository.deleteById(id);
    }
}