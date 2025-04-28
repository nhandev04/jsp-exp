package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAllCountries();
    
    Optional<Country> getCountryById(Long id);
    
    Country addCountry(Country country);
    
    Country updateCountry(Country country);
    
    void deleteCountry(Long id);
}