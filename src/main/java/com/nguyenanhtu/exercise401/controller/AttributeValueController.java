package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.AttributeValueRequest;
import com.nguyenanhtu.exercise401.entity.AttributeValue;
import com.nguyenanhtu.exercise401.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attribute-values")
public class AttributeValueController {

    @Autowired
    private AttributeValueService attributeValueService;

    @GetMapping
    public ResponseEntity<List<AttributeValue>> getAllAttributeValues() {
        List<AttributeValue> attributeValues = attributeValueService.getAllAttributeValues();
        return ResponseEntity.ok(attributeValues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeValue> getAttributeValueById(@PathVariable UUID id) {
        return attributeValueService.getAttributeValueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/attribute/{attributeId}")
    public ResponseEntity<List<AttributeValue>> getAttributeValuesByAttributeId(@PathVariable UUID attributeId) {
        List<AttributeValue> attributeValues = attributeValueService.getAttributeValuesByAttributeId(attributeId);
        return ResponseEntity.ok(attributeValues);
    }

    @PostMapping
    public ResponseEntity<AttributeValue> addAttributeValue(@RequestBody AttributeValueRequest attributeValueRequest) {
        AttributeValue createdAttributeValue = attributeValueService.addAttributeValue(attributeValueRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttributeValue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeValue> updateAttributeValue(@PathVariable UUID id, @RequestBody AttributeValueRequest attributeValueRequest) {
        try {
            AttributeValue updatedAttributeValue = attributeValueService.updateAttributeValue(id, attributeValueRequest);
            return ResponseEntity.ok(updatedAttributeValue);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValue(@PathVariable UUID id) {
        attributeValueService.deleteAttributeValue(id);
        return ResponseEntity.noContent().build();
    }
}