package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.GalleryRequest;
import com.nguyenanhtu.exercise401.entity.Gallery;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.repository.GalleryRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.service.GalleryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Gallery> getAllGalleries() {
        return galleryRepository.findAll();
    }

    @Override
    public Optional<Gallery> getGalleryById(UUID id) {
        return galleryRepository.findById(id);
    }

    @Override
    public List<Gallery> getGalleriesByProductId(UUID productId) {
        return galleryRepository.findByProductId(productId);
    }

    @Override
    public Gallery addGallery(GalleryRequest request) {
        Gallery gallery = new Gallery();
        return saveGallery(gallery, request);
    }

    @Override
    public Gallery updateGallery(UUID id, GalleryRequest request) {
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery not found with id: " + id));
        
        return saveGallery(gallery, request);
    }

    @Override
    public void deleteGallery(UUID id) {
        galleryRepository.deleteById(id);
    }
    
    private Gallery saveGallery(Gallery gallery, GalleryRequest request) {
        // Set basic properties
        gallery.setImage(request.getImage());
        gallery.setPlaceholder(request.getPlaceholder());
        gallery.setIsThumbnail(request.getIsThumbnail());
        
        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            gallery.setProduct(product);
        }
        
        // Save and return the gallery
        return galleryRepository.save(gallery);
    }
}