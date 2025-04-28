package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Gallery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GalleryService {
    List<Gallery> getAllGalleries();
    
    Optional<Gallery> getGalleryById(UUID id);
    
    List<Gallery> getGalleriesByProductId(UUID productId);
    
    Gallery addGallery(Gallery gallery);
    
    Gallery updateGallery(Gallery gallery);
    
    void deleteGallery(UUID id);
}