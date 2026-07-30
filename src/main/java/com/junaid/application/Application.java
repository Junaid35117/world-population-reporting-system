package com.junaid.application;

import com.junaid.report.CountryReport;
import com.junaid.service.MenuService;

public class Application {

    private final MenuService menuService;
    private final CountryReport countryReport;

    public Application() {
        this.menuService = new MenuService();
        this.countryReport = new CountryReport();
    }

    public void start() {

        boolean running = true;

        while (running) {

            int choice = menuService.getUserChoice();

            switch (choice) {

                case 1:
                    countryReport.displayAllCountriesByPopulation();
                    break;

                case 2:
                    String continent = menuService.getContinentName();
                    countryReport.displayCountriesByContinent(continent);
                    break;

                case 3:

                    String region = menuService.getRegionName();

                    countryReport.displayCountriesByRegion(region);

                    break;

                case 4:

                    int limit = menuService.getCountryLimit();

                    countryReport.displayTopCountries(limit);

                    break;

                case 0:
                    System.out.println();
                    System.out.println("=======================================");
                    System.out.println("Thank you for using World Report System");
                    System.out.println("=======================================");
                    running = false;
                    break;

                default:
                    System.out.println("Feature coming soon...");
            }

            System.out.println();
        }
    }
}