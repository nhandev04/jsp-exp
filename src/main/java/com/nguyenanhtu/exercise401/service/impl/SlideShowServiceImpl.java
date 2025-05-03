package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.SlideShowRequest;
import com.nguyenanhtu.exercise401.entity.SlideShow;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.SlideShowRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.SlideShowService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SlideShowServiceImpl implements SlideShowService {

    private final SlideShowRepository slideShowRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<SlideShow> getAllSlideShows() {
        return slideShowRepository.findAll();
    }

    @Override
    public Optional<SlideShow> getSlideShowById(UUID id) {
        return slideShowRepository.findById(id);
    }

    @Override
    public SlideShow addSlideShow(SlideShowRequest request) {
        SlideShow slideShow = new SlideShow();
        return saveSlideShow(slideShow, request);
    }

    @Override
    public SlideShow updateSlideShow(UUID id, SlideShowRequest request) {
        SlideShow slideShow = slideShowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SlideShow not found with id: " + id));
        
        return saveSlideShow(slideShow, request);
    }

    @Override
    public void deleteSlideShow(UUID id) {
        slideShowRepository.deleteById(id);
    }
    
    private SlideShow saveSlideShow(SlideShow slideShow, SlideShowRequest request) {
        // Set basic properties
        slideShow.setTitle(request.getTitle());
        slideShow.setDestinationUrl(request.getDestinationUrl());
        slideShow.setImage(request.getImage());
        slideShow.setPlaceholder(request.getPlaceholder());
        slideShow.setDescription(request.getDescription());
        slideShow.setBtnLabel(request.getBtnLabel());
        slideShow.setDisplayOrder(request.getDisplayOrder());
        slideShow.setPublished(request.getPublished());
        slideShow.setClicks(request.getClicks());
        slideShow.setStyles(request.getStyles());
        
        // Set createdBy if provided and this is a new slideshow
        if (request.getCreatedBy() != null && slideShow.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            slideShow.setCreatedBy(createdByAccount);
        }
        
        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            slideShow.setUpdatedBy(updatedByAccount);
        }
        
        // Save and return the slideshow
        return slideShowRepository.save(slideShow);
    }
}