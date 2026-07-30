package com.junaid.report;

import java.text.NumberFormat;
import java.util.List;

import com.junaid.model.Country;
import com.junaid.service.CountryService;

public class CountryReport {

    private final CountryService countryService;

    public CountryReport() {
        this.countryService = new CountryService();
    }

    private void printCountries(List<Country> countries) {

        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries found.");
            return;
        }

        System.out.println(
                "==========================================================================================================");

        System.out.printf("%-5s %-30s %-20s %-25s %15s%n",
                "Code",
                "Country",
                "Continent",
                "Region",
                "Population");

        System.out.println(
                "==========================================================================================================");

        NumberFormat formatter = NumberFormat.getInstance();

        for (Country country : countries) {

            System.out.printf("%-5s %-30s %-20s %-25s %15s%n",
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    formatter.format(country.getPopulation()));
        }

        System.out.println(
                "==========================================================================================================");
    }

    public void displayAllCountriesByPopulation() {

        List<Country> countries = countryService.getAllCountriesByPopulation();

        printCountries(countries);
    }

    public void displayCountriesByContinent(String continent) {

        List<Country> countries = countryService.getCountriesByContinent(continent);

        printCountries(countries);
    }

    public void displayCountriesByRegion(String region) {

        List<Country> countries = countryService.getCountriesByRegion(region);

        printCountries(countries);
    }

    public void displayTopCountries(int limit) {

        List<Country> countries = countryService.getTopCountries(limit);

        printCountries(countries);
    }
}