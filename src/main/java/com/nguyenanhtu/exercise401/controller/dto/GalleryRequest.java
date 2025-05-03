package com.nguyenanhtu.exercise401.controller.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class GalleryRequest {
    private UUID id;
    private UUID productId;
    private String image;
    private String placeholder;
    private Boolean isThumbnail;
}