package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, UUID> {
    @Query("SELECT av FROM AttributeValue av WHERE av.attribute.id = :attributeId")
    List<AttributeValue> findByAttributeId(@Param("attributeId") UUID attributeId);
}
