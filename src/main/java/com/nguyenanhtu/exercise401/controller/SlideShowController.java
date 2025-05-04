package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.SlideShowRequest;
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
    public ResponseEntity<SlideShow> addSlideShow(@RequestBody SlideShowRequest slideShowRequest) {
        SlideShow createdSlideShow = slideShowService.addSlideShow(slideShowRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSlideShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlideShow> updateSlideShow(@PathVariable UUID id, @RequestBody SlideShowRequest slideShowRequest) {
        try {
            SlideShow updatedSlideShow = slideShowService.updateSlideShow(id, slideShowRequest);
            return ResponseEntity.ok(updatedSlideShow);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlideShow(@PathVariable UUID id) {
        slideShowService.deleteSlideShow(id);
        return ResponseEntity.noContent().build();
    }
}