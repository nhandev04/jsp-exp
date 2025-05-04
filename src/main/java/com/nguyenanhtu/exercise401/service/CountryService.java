package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.CountryRequest;
import com.nguyenanhtu.exercise401.entity.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAllCountries();
    
    Optional<Country> getCountryById(Long id);

    Country addCountry(CountryRequest request);
    
    Country updateCountry(Long id, CountryRequest request);
    
    void deleteCountry(Long id);
}