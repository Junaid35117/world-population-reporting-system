package com.junaid.model;

public class PopulationReport {

    private String name;
    private long totalPopulation;
    private long cityPopulation;
    private long ruralPopulation;
    private double cityPercentage;
    private double ruralPercentage;

    public PopulationReport() {
    }

    public PopulationReport(String name, long totalPopulation,
            long cityPopulation, long ruralPopulation,
            double cityPercentage, double ruralPercentage) {
        this.name = name;
        this.totalPopulation = totalPopulation;
        this.cityPopulation = cityPopulation;
        this.ruralPopulation = ruralPopulation;
        this.cityPercentage = cityPercentage;
        this.ruralPercentage = ruralPercentage;
    }

    public String getName() {
        return name;
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

    public double getCityPercentage() {
        return cityPercentage;
    }

    public double getRuralPercentage() {
        return ruralPercentage;
    }
}