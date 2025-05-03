package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.ProductTagRequest;
import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.entity.ProductTag.ProductTagId;
import com.nguyenanhtu.exercise401.service.ProductTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-tags")
public class ProductTagController {

    @Autowired
    private ProductTagService productTagService;

    @GetMapping
    public ResponseEntity<List<ProductTag>> getAllProductTags() {
        List<ProductTag> productTags = productTagService.getAllProductTags();
        return ResponseEntity.ok(productTags);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductTag>> getProductTagsByProductId(@PathVariable UUID productId) {
        List<ProductTag> productTags = productTagService.getProductTagsByProductId(productId);
        return ResponseEntity.ok(productTags);
    }

    @GetMapping("/tag/{tagId}")
    public ResponseEntity<List<ProductTag>> getProductTagsByTagId(@PathVariable UUID tagId) {
        List<ProductTag> productTags = productTagService.getProductTagsByTagId(tagId);
        return ResponseEntity.ok(productTags);
    }

    @PostMapping
    public ResponseEntity<ProductTag> addProductTag(@RequestBody ProductTagRequest productTagRequest) {
        ProductTag createdProductTag = productTagService.addProductTag(productTagRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductTag);
    }

    @PutMapping
    public ResponseEntity<ProductTag> updateProductTag(@RequestBody ProductTagRequest productTagRequest) {
        try {
            ProductTag updatedProductTag = productTagService.updateProductTag(productTagRequest);
            return ResponseEntity.ok(updatedProductTag);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductTag(@RequestBody ProductTagRequest productTagRequest) {
        ProductTagId id = new ProductTagId(productTagRequest.getProductId(), productTagRequest.getTagId());
        productTagService.deleteProductTag(id);
        return ResponseEntity.noContent().build();
    }
}