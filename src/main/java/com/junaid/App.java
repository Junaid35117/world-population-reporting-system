package com.junaid;

import com.junaid.report.CountryReport;
import com.junaid.service.MenuService;

public class App {

    public static void main(String[] args) {

        MenuService menu = new MenuService();
        CountryReport report = new CountryReport();

        int choice = menu.getUserChoice();

        switch (choice) {

            case 1:
                report.displayAllCountriesByPopulation();
                break;

            case 5:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Feature coming soon...");
        }
    }
}