package com.junaid.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final DatabaseConfig config;

    public DatabaseConnection() {
        this.config = new DatabaseConfig();
    }

    public Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }
}