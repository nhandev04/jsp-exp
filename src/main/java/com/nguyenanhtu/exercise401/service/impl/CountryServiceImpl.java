package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.CountryRequest;
import com.nguyenanhtu.exercise401.entity.Country;
import com.nguyenanhtu.exercise401.repository.CountryRepository;
import com.nguyenanhtu.exercise401.service.CountryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(UUID.fromString(id.toString()));
    }

    @Override
    public Country addCountry(CountryRequest request) {
        Country country = new Country();
        return saveCountry(country, request);
    }

    @Override
    public Country updateCountry(Long id, CountryRequest request) {
        Country country = countryRepository.findById(UUID.fromString(id.toString()))
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        
        return saveCountry(country, request);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(UUID.fromString(id.toString()));
    }
    
    private Country saveCountry(Country country, CountryRequest request) {
        // Set basic properties
        country.setName(request.getName());
        country.setIso(request.getName());  // Using name as ISO code
        country.setIso3(request.getIso3());
        country.setNumCode(request.getNumCode());
        country.setPhoneCode(request.getPhoneCode());
        
        // Save and return the country
        return countryRepository.save(country);
    }
}