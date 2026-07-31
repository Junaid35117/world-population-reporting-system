package com.junaid.service;

import java.util.List;

import com.junaid.model.Country;
import com.junaid.model.CountryPopulation;
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

    public List<Country> getTopCountries(int limit) {
        return countryRepository.getTopCountries(limit);
    }

    public List<CountryPopulation> getCountryPopulationReport() {
        return countryRepository.getCountryPopulationReport();
    }
}