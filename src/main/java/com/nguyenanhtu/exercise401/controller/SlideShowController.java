package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.SlideShow;
import com.nguyenanhtu.exercise401.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/slideshows")
public class SlideShowController {

    @Autowired
    private SlideShowService slideShowService;

    @GetMapping
    public ResponseEntity<List<SlideShow>> getAllSlideShows() {
        List<SlideShow> slideShows = slideShowService.getAllSlideShows();
        return ResponseEntity.ok(slideShows);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlideShow> getSlideShowById(@PathVariable UUID id) {
        return slideShowService.getSlideShowById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SlideShow> addSlideShow(@RequestBody SlideShow slideShow) {
        SlideShow createdSlideShow = slideShowService.addSlideShow(slideShow);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSlideShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlideShow> updateSlideShow(@PathVariable UUID id, @RequestBody SlideShow slideShow) {
        slideShow.setId(id);
        SlideShow updatedSlideShow = slideShowService.updateSlideShow(slideShow);
        return ResponseEntity.ok(updatedSlideShow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlideShow(@PathVariable UUID id) {
        slideShowService.deleteSlideShow(id);
        return ResponseEntity.noContent().build();
    }
}