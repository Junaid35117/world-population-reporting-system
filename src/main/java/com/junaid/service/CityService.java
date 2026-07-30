package com.junaid.service;

import java.util.List;
import com.junaid.model.City;
import com.junaid.repository.CityRepository;

public class CityService {

    private final CityRepository cityRepository;

    public CityService() {
        this.cityRepository = new CityRepository();
    }

    public List<City> getAllCitiesByPopulation() {
        return cityRepository.getAllCitiesByPopulation();
    }

    public List<City> getCitiesByCountry(String countryName) {
        return cityRepository.getCitiesByCountry(countryName);
    }
}