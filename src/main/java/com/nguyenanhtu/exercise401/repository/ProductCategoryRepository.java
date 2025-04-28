package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
    @Query("SELECT pc FROM ProductCategory pc WHERE pc.product.id = :productId")
    List<ProductCategory> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT pc FROM ProductCategory pc WHERE pc.category.id = :categoryId")
    List<ProductCategory> findByCategoryId(@Param("categoryId") UUID categoryId);
}
