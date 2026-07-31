package com.junaid.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountryPopulationTest {
    CountryPopulation countryPopulation = new CountryPopulation(
            "Pakistan", 240485658, 240485658, 240485658);

    @Test
    void constructorShouldSetValues() {
        assertEquals("Pakistan", countryPopulation.getCountryName());
        assertEquals(240485658, countryPopulation.getTotalPopulation());
        assertEquals(240485658, countryPopulation.getCityPopulation());
        assertEquals(240485658, countryPopulation.getRuralPopulation());
    }
}
