package com.junaid.repository;

import com.junaid.database.DatabaseConnection;

public class CityRepository {

    private final DatabaseConnection databaseConnection;

    public CityRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

}