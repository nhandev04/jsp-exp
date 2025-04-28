package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Tag;
import com.nguyenanhtu.exercise401.repository.TagRepository;
import com.nguyenanhtu.exercise401.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(UUID id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(UUID id) {
        tagRepository.deleteById(id);
    }
}