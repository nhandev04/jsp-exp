package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.ProductTagRequest;
import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.service.ProductTagService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-tags")
public class ProductTagController {

    private final ProductTagService productTagService;

    @GetMapping
    public ResponseEntity<List<ProductTag>> getAllProductTags() {
        List<ProductTag> productTags = productTagService.getAllProductTags();
        return ResponseEntity.ok(productTags);
    }

    @GetMapping("/{productId}/{tagId}")
    public ResponseEntity<ProductTag> getProductTagById(
            @PathVariable UUID productId,
            @PathVariable UUID tagId) {
        return productTagService.getProductTagById(productId, tagId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
    public ResponseEntity<ProductTag> createProductTag(@RequestBody ProductTagRequest request) {
        ProductTag createdProductTag = productTagService.addProductTag(request);
        return new ResponseEntity<>(createdProductTag, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductTag> updateProductTag(@RequestBody ProductTagRequest request) {
        return ResponseEntity.ok(productTagService.updateProductTag(request));
    }

    @DeleteMapping("/{productId}/{tagId}")
    public ResponseEntity<Void> deleteProductTag(
            @PathVariable UUID productId,
            @PathVariable UUID tagId) {
        productTagService.deleteProductTag(productId, tagId);
        return ResponseEntity.noContent().build();
    }
}
