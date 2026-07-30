package com.junaid.report;

import java.text.NumberFormat;
import java.util.List;

import com.junaid.model.City;
import com.junaid.service.CityService;

public class CityReport {

    private final CityService cityService;

    public CityReport() {
        this.cityService = new CityService();
    }

    private void printCities(List<City> cities) {

        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities found.");
            return;
        }

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println(
                "==============================================================================================================");

        System.out.printf("%-30s %-25s %-25s %15s%n",
                "City",
                "Country",
                "District",
                "Population");

        System.out.println(
                "==============================================================================================================");

        for (City city : cities) {

            System.out.printf("%-30s %-25s %-25s %15s%n",
                    city.getName(),
                    city.getCountryName(),
                    city.getDistrict(),
                    formatter.format(city.getPopulation()));
        }

        System.out.println(
                "==============================================================================================================");
    }

    public void displayAllCitiesByPopulation() {

        List<City> cities = cityService.getAllCitiesByPopulation();

        printCities(cities);
    }

    public void displayCitiesByCountry(String countryName) {

        List<City> cities = cityService.getCitiesByCountry(countryName);

        printCities(cities);
    }
}