package com.junaid;

import com.junaid.report.CountryReport;

public class App {

    public static void main(String[] args) {

        CountryReport report = new CountryReport();

        report.displayAllCountriesByPopulation();
    }
}