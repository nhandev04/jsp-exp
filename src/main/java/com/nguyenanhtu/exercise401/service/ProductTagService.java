package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.ProductTagRequest;
import com.nguyenanhtu.exercise401.entity.ProductTag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductTagService {
    List<ProductTag> getAllProductTags();
    
    Optional<ProductTag> getProductTagById(UUID productId, UUID tagId);
    
    List<ProductTag> getProductTagsByProductId(UUID productId);
    
    List<ProductTag> getProductTagsByTagId(UUID tagId);

    ProductTag addProductTag(ProductTagRequest request);
    
    ProductTag updateProductTag(ProductTagRequest request);
    
    void deleteProductTag(UUID productId, UUID tagId);
}