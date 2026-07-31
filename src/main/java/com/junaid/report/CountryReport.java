package com.junaid.report;

import java.text.NumberFormat;
import java.util.List;

import com.junaid.model.Country;
import com.junaid.model.CountryPopulation;
import com.junaid.model.PopulationReport;
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

    private void displayPopulationReport(PopulationReport report) {

        if (report == null) {
            System.out.println("No data found.");
            return;
        }

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Population Report");
        System.out.println("=========================================");
        System.out.println("Name               : " + report.getName());
        System.out.println("Total Population   : " + formatter.format(report.getTotalPopulation()));
        System.out.println("City Population    : " + formatter.format(report.getCityPopulation())
                + String.format(" (%.2f%%)", report.getCityPercentage()));
        System.out.println("Rural Population   : " + formatter.format(report.getRuralPopulation())
                + String.format(" (%.2f%%)", report.getRuralPercentage()));
        System.out.println("=========================================");
    }

    public PopulationReport getWorldPopulation() {
        return countryService.getWorldPopulationReport();
    }

    public void displayWorldPopulation() {

        PopulationReport report = countryService.getWorldPopulationReport();

        displayPopulationReport(report);
    }

    public void displayContinentPopulation(String continent) {

        PopulationReport report = countryService.getContinentPopulationReport(continent);

        displayPopulationReport(report);
    }

    public void displayRegionPopulation(String region) {
        PopulationReport report = countryService.getRegionPopulationReport(region);

        displayPopulationReport(report);
    }

    public void displayCountryPopulation(String country) {
        PopulationReport report = countryService.getCountryPopulationReport(country);

        displayPopulationReport(report);
    }

    public void displayDistrictPopulation(String district) {
        PopulationReport report = countryService.getDistrictPopulationReport(district);

        displayPopulationReport(report);
    }

    public void displayCityPopulation(String city) {
        PopulationReport report = countryService.getCityPopulationReport(city);

        displayPopulationReport(report);
    }
}