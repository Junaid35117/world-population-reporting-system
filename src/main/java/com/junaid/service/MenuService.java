package com.junaid.service;

import java.util.Scanner;

public class MenuService {

    private final Scanner scanner;

    public MenuService() {
        this.scanner = new Scanner(System.in);
    }

    public int getUserChoice() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("        WORLD POPULATION REPORT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. All Countries by Population");
        System.out.println("2. Countries by Continent");
        System.out.println("3. Countries by Region");
        System.out.println("4. Top N Countries");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------------");
        System.out.print("Enter your choice: ");

        return scanner.nextInt();
    }
}