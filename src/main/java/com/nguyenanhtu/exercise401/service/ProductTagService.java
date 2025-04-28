package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.entity.ProductTag.ProductTagId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductTagService {
    List<ProductTag> getAllProductTags();
    
    Optional<ProductTag> getProductTagById(ProductTagId id);
    
    List<ProductTag> getProductTagsByProductId(UUID productId);
    
    List<ProductTag> getProductTagsByTagId(UUID tagId);
    
    ProductTag addProductTag(ProductTag productTag);
    
    ProductTag updateProductTag(ProductTag productTag);
    
    void deleteProductTag(ProductTagId id);
}