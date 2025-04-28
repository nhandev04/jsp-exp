package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.SlideShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SlideShowRepository extends JpaRepository<SlideShow, UUID> {
}
