package com.nguyenanhtu.exercise401.controller.dto;

import lombok.Data;

@Data
public class CountryRequest {
    private Long id;
    private String iso;
    private String name;
    private String upperName;
    private String iso3;
    private Short numCode;
    private Integer phoneCode;
}