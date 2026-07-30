package com.junaid.service;

import java.util.List;

import com.junaid.model.Country;
import com.junaid.repository.CountryRepository;

public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService() {
        this.countryRepository = new CountryRepository();
    }

    public List<Country> getAllCountriesByPopulation() {
        return countryRepository.getAllCountriesByPopulation();
    }

    public List<Country> getCountriesByContinent(String continent) {
        return countryRepository.getCountriesByContinent(continent);
    }

    public List<Country> getCountriesByRegion(String region) {
        return countryRepository.getCountriesByRegion(region);
    }
}