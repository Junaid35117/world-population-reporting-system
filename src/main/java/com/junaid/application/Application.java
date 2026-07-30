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
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                case 1:
                    countryReport.displayAllCountriesByPopulation();
                    break;

                default:
                    System.out.println("Feature coming soon...");
            }

            System.out.println();
        }
    }
}