package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Gallery;
import com.nguyenanhtu.exercise401.repository.GalleryRepository;
import com.nguyenanhtu.exercise401.service.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;

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
    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public void deleteGallery(UUID id) {
        galleryRepository.deleteById(id);
    }
}