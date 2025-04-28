package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductTag;
import com.nguyenanhtu.exercise401.entity.ProductTag.ProductTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, ProductTagId> {
    @Query("SELECT pt FROM ProductTag pt WHERE pt.id.productId = :productId")
    List<ProductTag> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT pt FROM ProductTag pt WHERE pt.id.tagId = :tagId")
    List<ProductTag> findByTagId(@Param("tagId") UUID tagId);
}
