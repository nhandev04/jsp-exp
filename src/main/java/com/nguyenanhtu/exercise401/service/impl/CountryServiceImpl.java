package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.CountryRequest;
import com.nguyenanhtu.exercise401.entity.Country;
import com.nguyenanhtu.exercise401.repository.CountryRepository;
import com.nguyenanhtu.exercise401.service.CountryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return countryRepository.findById(id);
    }

    @Override
    public Country addCountry(CountryRequest request) {
        Country country = new Country();
        return saveCountry(country, request);
    }

    @Override
    public Country updateCountry(Long id, CountryRequest request) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));

        return saveCountry(country, request);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    private Country saveCountry(Country country, CountryRequest request) {
        // Set basic properties

        if (request.getUpperName() != null) {
            country.setUpperName(request.getUpperName());
        }

        if (request.getName() != null) {
            country.setName(request.getName());
        }

        if (request.getIso() != null) { // Using Iso as ISO code
            country.setIso(request.getIso());
        }

        if (request.getIso3() != null) {
            country.setIso3(request.getIso3());
        }

        if (request.getNumCode() != null) {
            country.setNumCode(request.getNumCode());
        }

        if (request.getPhoneCode() != null) {
            country.setPhoneCode(request.getPhoneCode());
        }

        // Save and return the country
        return countryRepository.save(country);
    }
}