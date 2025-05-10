package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findBySlug(String slug);
    
    @Query("SELECT p FROM Product p " +
           "LEFT JOIN FETCH p.productTags pt " +
           "LEFT JOIN FETCH pt.tag " +
           "WHERE p.id = :id")
    Optional<Product> findByIdWithTags(@Param("id") UUID id);
    
    @Query("SELECT p FROM Product p " +
           "LEFT JOIN FETCH p.productTags pt " +
           "LEFT JOIN FETCH pt.tag " +
           "WHERE p.slug = :slug")
    Optional<Product> findBySlugWithTags(@Param("slug") String slug);
}
