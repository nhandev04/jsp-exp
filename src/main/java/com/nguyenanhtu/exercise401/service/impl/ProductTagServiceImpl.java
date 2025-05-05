package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.ProductTagRequest;
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
    private final ProductRepository productRepository;
    private final TagRepository tagRepository;

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
    public ProductTag updateProductTag(ProductTagRequest request) {
        // For composite key entities, update is basically a check if it exists
        ProductTagId id = new ProductTagId(request.getProductId(), request.getTagId());

        return productTagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductTag not found with productId: " +
                        request.getProductId() + " and tagId: " + request.getTagId()));
    }

    @Override
    public void deleteProductTag(UUID productId, UUID tagId) {
        ProductTagId id = new ProductTagId(productId, tagId);
        productTagRepository.deleteById(id);
    }
}