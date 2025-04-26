package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}