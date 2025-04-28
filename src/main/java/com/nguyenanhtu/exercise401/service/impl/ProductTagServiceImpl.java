package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.entity.ProductTag.ProductTagId;
import com.nguyenanhtu.exercise401.repository.ProductTagRepository;
import com.nguyenanhtu.exercise401.service.ProductTagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductTagServiceImpl implements ProductTagService {

    private final ProductTagRepository productTagRepository;

    @Override
    public List<ProductTag> getAllProductTags() {
        return productTagRepository.findAll();
    }

    @Override
    public Optional<ProductTag> getProductTagById(ProductTagId id) {
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
    public ProductTag addProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    @Override
    public ProductTag updateProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    @Override
    public void deleteProductTag(ProductTagId id) {
        productTagRepository.deleteById(id);
    }
}