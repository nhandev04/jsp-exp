package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.AttributeRequest;
import com.nguyenanhtu.exercise401.entity.Attribute;
import com.nguyenanhtu.exercise401.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping
    public ResponseEntity<List<Attribute>> getAllAttributes() {
        List<Attribute> attributes = attributeService.getAllAttributes();
        return ResponseEntity.ok(attributes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable UUID id) {
        return attributeService.getAttributeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Attribute> addAttribute(@RequestBody AttributeRequest attributeRequest) {
        Attribute createdAttribute = attributeService.addAttribute(attributeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttribute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attribute> updateAttribute(@PathVariable UUID id, @RequestBody AttributeRequest attributeRequest) {
        try {
            Attribute updatedAttribute = attributeService.updateAttribute(id, attributeRequest);
            return ResponseEntity.ok(updatedAttribute);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable UUID id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.noContent().build();
    }
}