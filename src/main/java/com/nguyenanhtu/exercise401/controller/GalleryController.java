package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.GalleryRequest;
import com.nguyenanhtu.exercise401.entity.Gallery;
import com.nguyenanhtu.exercise401.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/galleries")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllGalleries() {
        List<Gallery> galleries = galleryService.getAllGalleries();
        return ResponseEntity.ok(galleries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable UUID id) {
        return galleryService.getGalleryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Gallery>> getGalleriesByProductId(@PathVariable UUID productId) {
        List<Gallery> galleries = galleryService.getGalleriesByProductId(productId);
        return ResponseEntity.ok(galleries);
    }

    @PostMapping
    public ResponseEntity<Gallery> addGallery(@RequestBody GalleryRequest galleryRequest) {
        Gallery createdGallery = galleryService.addGallery(galleryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGallery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable UUID id, @RequestBody GalleryRequest galleryRequest) {
        try {
            Gallery updatedGallery = galleryService.updateGallery(id, galleryRequest);
            return ResponseEntity.ok(updatedGallery);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable UUID id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }
}