package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.SlideShow;
import com.nguyenanhtu.exercise401.repository.SlideShowRepository;
import com.nguyenanhtu.exercise401.service.SlideShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SlideShowServiceImpl implements SlideShowService {

    private final SlideShowRepository slideShowRepository;

    @Override
    public List<SlideShow> getAllSlideShows() {
        return slideShowRepository.findAll();
    }

    @Override
    public Optional<SlideShow> getSlideShowById(UUID id) {
        return slideShowRepository.findById(id);
    }

    @Override
    public SlideShow addSlideShow(SlideShow slideShow) {
        return slideShowRepository.save(slideShow);
    }

    @Override
    public SlideShow updateSlideShow(SlideShow slideShow) {
        return slideShowRepository.save(slideShow);
    }

    @Override
    public void deleteSlideShow(UUID id) {
        slideShowRepository.deleteById(id);
    }
}