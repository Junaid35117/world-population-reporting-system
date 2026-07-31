package com.junaid.report;

import java.text.NumberFormat;
import java.util.List;

import com.junaid.model.Country;
import com.junaid.model.CountryPopulation;
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

    public void displayCountryPopulationReport() {

        List<CountryPopulation> countries = countryService.getCountryPopulationReport();

        if (countries == null || countries.isEmpty()) {
            System.out.println("No data found.");
            return;
        }

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println(
                "==============================================================================================================");
        System.out.printf("%-30s %18s %20s %22s%n",
                "Country",
                "Total Population",
                "City Population",
                "Non-City Population");
        System.out.println(
                "==============================================================================================================");

        for (CountryPopulation country : countries) {

            System.out.printf("%-30s %18s %20s %22s%n",
                    country.getCountryName(),
                    formatter.format(country.getTotalPopulation()),
                    formatter.format(country.getCityPopulation()),
                    formatter.format(country.getRuralPopulation()));
        }

        System.out.println(
                "==============================================================================================================");
    }

    public long getWorldPopulation() {
        List<CountryPopulation> countries = countryService.getCountryPopulationReport();

        long worldPopulation = 0;

        for (CountryPopulation country : countries) {
            worldPopulation += country.getTotalPopulation();
        }

        return worldPopulation;
    }

    public void displayWorldPopulation() {
        long worldPopulation = getWorldPopulation();

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("World Population: " + formatter.format(worldPopulation));
    }

    public void displayContinentPopulation(String continent) {
        long continentPopulation = countryService.getContinentPopulation(continent);

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("Population of " + continent + ": " + formatter.format(continentPopulation));
    }

    public void displayRegionPopulation(String region) {
        long regionPopulation = countryService.getRegionPopulation(region);

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("Population of " + region + ": " + formatter.format(regionPopulation));
    }

    public void displayCountryPopulation(String country) {
        long countryPopulation = countryService.getCountryPopulation(country);

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("Population of " + country + ": " + formatter.format(countryPopulation));
    }

    public void displayDistrictPopulation(String district) {
        long districtPopulation = countryService.getDistrictPopulation(district);

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("Population of " + district + ": " + formatter.format(districtPopulation));
    }

    public void displayCityPopulation(String city) {
        long cityPopulation = countryService.getCityPopulation(city);

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("Population of " + city + ": " + formatter.format(cityPopulation));
    }
}