package com.junaid.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    City city = new City(
            0,
            "Lahore",
            "PAK",
            "PAK",
            "Punjab",
            11126285);

    @Test
    void constructorShouldSetValues() {
        assertEquals(0, city.getId());
        assertEquals("Lahore", city.getName());
        assertEquals("PAK", city.getCountryCode());
        assertEquals("Punjab", city.getDistrict());
        assertEquals(11126285, city.getPopulation());
        assertEquals("PAK", city.getCountryName());
    }
}
