package com.junaid.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junaid.model.City;

class CityServiceTest {

    private CityService cityService;

    @BeforeEach
    void setUp() {
        cityService = new CityService();
    }

    @Test
    void shouldReturnAllCities() {

        List<City> cities = cityService.getAllCitiesByPopulation();

        assertNotNull(cities);
        assertFalse(cities.isEmpty());
    }

    @Test
    void shouldReturnCitiesByCountry() {

        List<City> cities = cityService.getCitiesByCountry("Pakistan");

        assertNotNull(cities);
        assertFalse(cities.isEmpty());
    }

    @Test
    void shouldReturnCitiesByDistrict() {

        List<City> cities = cityService.getCitiesByDistrict("Punjab");

        assertNotNull(cities);
    }

    @Test
    void shouldReturnCapitalCities() {

        List<City> cities = cityService.getAllCapitalCities();

        assertNotNull(cities);
        assertFalse(cities.isEmpty());
    }

}