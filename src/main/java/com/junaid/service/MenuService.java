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
            System.out.println();
            System.out.println("POPULATION REPORTS");
            System.out.println("8. World Population");
            System.out.println("9. Continent Population");
            System.out.println("10. Region Population");
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
}