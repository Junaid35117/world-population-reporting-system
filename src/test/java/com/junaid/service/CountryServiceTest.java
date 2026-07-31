package com.junaid.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junaid.model.Country;

class CountryServiceTest {

    private CountryService countryService;

    @BeforeEach
    void setUp() {
        countryService = new CountryService();
    }

    @Test
    void shouldReturnAllCountries() {

        List<Country> countries = countryService.getAllCountriesByPopulation();

        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    @Test
    void shouldReturnCountriesByContinent() {

        List<Country> countries = countryService.getCountriesByContinent("Asia");

        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    @Test
    void shouldReturnCountriesByRegion() {

        List<Country> countries = countryService.getCountriesByRegion("EAstern Asia");

        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    @Test
    void shouldReturnTopCountries() {

        List<Country> countries = countryService.getTopCountries(5);

        assertEquals(5, countries.size());
    }

    @Test
    void shouldReturnWorldPopulation() {

        long population = countryService.getWorldPopulation();

        assertTrue(population > 0);
    }

}