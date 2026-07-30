package com.junaid;

import com.junaid.database.DatabaseConfig;

public class App {

    public static void main(String[] args) {

        DatabaseConfig config = new DatabaseConfig();

        System.out.println("Database URL: " + config.getUrl());
        System.out.println("Database Username: " + config.getUsername());
        System.out.println("Configuration loaded successfully.");
    }
}