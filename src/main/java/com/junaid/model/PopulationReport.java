package com.junaid.model;

public class PopulationReport {

    private String name;
    private long population;

    public PopulationReport() {
    }

    public PopulationReport(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }
}