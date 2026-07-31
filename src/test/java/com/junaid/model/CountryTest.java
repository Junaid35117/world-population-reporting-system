package com.junaid.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void constructorShouldSetValues() {

        Country country = new Country(
                "PAK",
                "Pakistan",
                "Asia",
                "Southern Asia",
                240485658);

        assertEquals("PAK", country.getCode());
        assertEquals("Pakistan", country.getName());
        assertEquals("Asia", country.getContinent());
        assertEquals("Southern Asia", country.getRegion());
        assertEquals(240485658, country.getPopulation());
    }
}