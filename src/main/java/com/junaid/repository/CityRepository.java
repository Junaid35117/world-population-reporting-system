package com.junaid.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.junaid.database.DatabaseConnection;
import com.junaid.model.City;

public class CityRepository {

    private final DatabaseConnection databaseConnection;

    public CityRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public List<City> getAllCitiesByPopulation() {

        List<City> cities = new ArrayList<>();

        String sql = """
                SELECT c.ID,
                       c.Name,
                       c.CountryCode,
                       co.Name AS CountryName,
                       c.District,
                       c.Population
                FROM city c
                JOIN country co
                    ON c.CountryCode = co.Code
                ORDER BY c.Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                City city = new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("CountryName"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population"));

                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public List<City> getCitiesByCountry(String countryName) {

        List<City> cities = new ArrayList<>();

        String sql = """
                SELECT c.ID,
                       c.Name,
                       c.CountryCode,
                       co.Name AS CountryName,
                       c.District,
                       c.Population
                FROM city c
                JOIN country co
                    ON c.CountryCode = co.Code
                WHERE co.Name = ?
                ORDER BY c.Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, countryName);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("CountryName"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population"));

                    cities.add(city);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public List<City> getCitiesByDistrict(String district) {

        List<City> cities = new ArrayList<>();

        String sql = """
                SELECT c.ID,
                       c.Name,
                       c.CountryCode,
                       co.Name AS CountryName,
                       c.District,
                       c.Population
                FROM city c
                JOIN country co
                    ON c.CountryCode = co.Code
                WHERE c.District = ?
                ORDER BY c.Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, district);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("CountryName"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population"));

                    cities.add(city);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public List<City> getAllCapitalCities() {

        List<City> cities = new ArrayList<>();

        String sql = """
                SELECT
                    c.ID,
                    c.Name,
                    c.CountryCode,
                    co.Name AS CountryName,
                    c.District,
                    c.Population
                FROM city c
                INNER JOIN country co
                    ON c.ID = co.Capital
                ORDER BY c.Population DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                City city = new City(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("CountryName"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population"));

                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }
}