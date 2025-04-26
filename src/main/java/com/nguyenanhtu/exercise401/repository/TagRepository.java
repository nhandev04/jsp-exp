package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}