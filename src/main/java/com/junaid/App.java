package com.junaid;

import java.sql.Connection;

import com.junaid.database.DatabaseConnection;

public class App {

    public static void main(String[] args) {

        DatabaseConnection databaseConnection = new DatabaseConnection();

        try (Connection connection = databaseConnection.getConnection()) {

            if (connection != null && !connection.isClosed()) {
                System.out.println("Successfully connected to the World database!");
            }

        } catch (Exception e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}