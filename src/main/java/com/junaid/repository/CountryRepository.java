package com.junaid.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.junaid.database.DatabaseConnection;
import com.junaid.model.Country;

public class CountryRepository {

    private final DatabaseConnection databaseConnection;

    public CountryRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public List<Country> getAllCountriesByPopulation() {

        List<Country> countries = new ArrayList<>();

        String sql = """
                SELECT Code,
                       Name,
                       Continent,
                       Region,
                       Population
                FROM country
                ORDER BY Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Country country = new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region"),
                        resultSet.getInt("Population"));

                countries.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public List<Country> getCountriesByContinent(String continent) {

        List<Country> countries = new ArrayList<>();

        String sql = """
                SELECT Code,
                       Name,
                       Continent,
                       Region,
                       Population
                FROM country
                WHERE Continent = ?
                ORDER BY Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, continent);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Country country = new Country(
                            resultSet.getString("Code"),
                            resultSet.getString("Name"),
                            resultSet.getString("Continent"),
                            resultSet.getString("Region"),
                            resultSet.getInt("Population"));

                    countries.add(country);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public List<Country> getCountriesByRegion(String region) {

        List<Country> countries = new ArrayList<>();

        String sql = """
                SELECT Code,
                       Name,
                       Continent,
                       Region,
                       Population
                FROM country
                WHERE Region = ?
                ORDER BY Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, region);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Country country = new Country(
                            resultSet.getString("Code"),
                            resultSet.getString("Name"),
                            resultSet.getString("Continent"),
                            resultSet.getString("Region"),
                            resultSet.getInt("Population"));

                    countries.add(country);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public List<Country> getTopCountries(int limit) {

        List<Country> countries = new ArrayList<>();

        String sql = """
                SELECT Code,
                       Name,
                       Continent,
                       Region,
                       Population
                FROM country
                ORDER BY Population DESC
                LIMIT ?
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, limit);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Country country = new Country(
                            resultSet.getString("Code"),
                            resultSet.getString("Name"),
                            resultSet.getString("Continent"),
                            resultSet.getString("Region"),
                            resultSet.getInt("Population"));

                    countries.add(country);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }
}