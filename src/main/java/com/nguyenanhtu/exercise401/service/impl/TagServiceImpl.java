package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Tag;
import com.nguyenanhtu.exercise401.controller.request.TagRequest;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.TagRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.TagService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(UUID id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag addTag(TagRequest request) {
        Tag tag = new Tag();
        return saveTag(tag, request);
    }

    @Override
    public Tag updateTag(UUID id, TagRequest request) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + id));
        
        return saveTag(tag, request);
    }

    @Override
    public void deleteTag(UUID id) {
        tagRepository.deleteById(id);
    }
    
    private Tag saveTag(Tag tag, TagRequest request) {
        // Set basic properties
        tag.setTagName(request.getTagName());
        tag.setIcon(request.getIcon());
        
        // Set createdBy if provided and this is a new tag
        if (request.getCreatedById() != null && tag.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedById())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getCreatedById()));
            tag.setCreatedBy(createdByAccount);
        }
        
        // Set updatedBy if provided
        if (request.getUpdatedById() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedById())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getUpdatedById()));
            tag.setUpdatedBy(updatedByAccount);
        }
        
        // Save and return the tag
        return tagRepository.save(tag);
    }
}