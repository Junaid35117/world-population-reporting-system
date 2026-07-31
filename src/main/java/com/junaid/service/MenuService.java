package com.junaid.service;

import java.util.Scanner;

public class MenuService {

    private final Scanner scanner;

    public MenuService() {
        this.scanner = new Scanner(System.in);
    }

    public int getUserChoice() {

        while (true) {

            System.out.println();
            System.out.println("=======================================================");
            System.out.println("           WORLD POPULATION REPORT SYSTEM");
            System.out.println("=======================================================");
            System.out.println("COUNTRY REPORTS");
            System.out.println("1. All Countries by Population");
            System.out.println("2. Countries by Continent");
            System.out.println("3. Countries by Region");
            System.out.println("4. Top N Countries");
            System.out.println();
            System.out.println("CITY REPORTS");
            System.out.println("5. All Cities by Population");
            System.out.println("6. Cities in a Country");
            System.out.println("7. Cities in a District");
            System.out.println("8. All Capital Cities");
            System.out.println("8. Display Top N Capital Cities");
            System.out.println();
            System.out.println("POPULATION REPORTS");
            System.out.println("10. Country Population Report");
            System.out.println("11.World Population");
            System.out.println("12. Continent Population");
            System.out.println("13. Region Population");
            System.out.println("14. Country Population");
            System.out.println("15. District Population");
            System.out.println("16. City Population");
            System.out.println();
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println();
            System.out.println("Invalid input. Please enter a number.");

            scanner.nextLine();
        }
    }

    public String getContinentName() {

        scanner.nextLine();

        while (true) {

            System.out.print("Enter Continent Name: ");

            String continent = scanner.nextLine().trim();

            if (!continent.isEmpty()) {
                return continent;
            }

            System.out.println("Continent name cannot be empty.");
        }
    }

    public String getRegionName() {

        scanner.nextLine();

        while (true) {

            System.out.print("Enter Region Name: ");

            String region = scanner.nextLine().trim();

            if (!region.isEmpty()) {
                return region;
            }

            System.out.println("Region cannot be empty.");
        }
    }

    public int getLimit() {

        while (true) {

            System.out.print("Enter Number: ");

            if (scanner.hasNextInt()) {

                int limit = scanner.nextInt();

                if (limit > 0) {
                    return limit;
                }

                System.out.println("Number must be greater than zero.");
            } else {

                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public String getCountryName() {

        scanner.nextLine();

        while (true) {

            System.out.print("Enter Country Name: ");

            String country = scanner.nextLine().trim();

            if (!country.isEmpty()) {
                return country;
            }

            System.out.println("Country name cannot be empty.");
        }
    }

    public String getDistrictName() {

        scanner.nextLine();

        while (true) {

            System.out.print("Enter District Name: ");

            String district = scanner.nextLine().trim();

            if (!district.isEmpty()) {
                return district;
            }

            System.out.println("District name cannot be empty.");
        }
    }
}