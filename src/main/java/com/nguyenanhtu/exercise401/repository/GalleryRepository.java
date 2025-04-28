package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, UUID> {
    List<Gallery> findByProductId(UUID productId);
}
