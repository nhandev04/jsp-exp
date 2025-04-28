package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Tag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagService {
    List<Tag> getAllTags();
    
    Optional<Tag> getTagById(UUID id);
    
    Tag addTag(Tag tag);
    
    Tag updateTag(Tag tag);
    
    void deleteTag(UUID id);
}