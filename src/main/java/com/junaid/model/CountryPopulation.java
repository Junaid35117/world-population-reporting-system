package com.junaid.model;

public class CountryPopulation {

    private String countryName;
    private long totalPopulation;
    private long cityPopulation;
    private long ruralPopulation;

    public CountryPopulation() {
    }

    public CountryPopulation(String countryName,
            long totalPopulation,
            long cityPopulation,
            long ruralPopulation) {

        this.countryName = countryName;
        this.totalPopulation = totalPopulation;
        this.cityPopulation = cityPopulation;
        this.ruralPopulation = ruralPopulation;
    }

    public String getCountryName() {
        return countryName;
    }

    public long getTotalPopulation() {
        return totalPopulation;
    }

    public long getCityPopulation() {
        return cityPopulation;
    }

    public long getRuralPopulation() {
        return ruralPopulation;
    }
}