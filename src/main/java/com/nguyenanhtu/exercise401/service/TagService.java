package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.TagRequest;
import com.nguyenanhtu.exercise401.entity.Tag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagService {
    List<Tag> getAllTags();
    
    Optional<Tag> getTagById(UUID id);

    Tag addTag(TagRequest request);
    
    Tag updateTag(UUID id, TagRequest request);
    
    void deleteTag(UUID id);
}