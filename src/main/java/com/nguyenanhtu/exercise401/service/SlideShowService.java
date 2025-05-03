package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.SlideShowRequest;
import com.nguyenanhtu.exercise401.entity.SlideShow;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SlideShowService {
    List<SlideShow> getAllSlideShows();
    
    Optional<SlideShow> getSlideShowById(UUID id);

    SlideShow addSlideShow(SlideShowRequest request);
    
    SlideShow updateSlideShow(UUID id, SlideShowRequest request);
    
    void deleteSlideShow(UUID id);
}