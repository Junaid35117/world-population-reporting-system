package com.junaid.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.junaid.database.DatabaseConnection;
import com.junaid.model.Country;
import com.junaid.model.CountryPopulation;

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

    public List<CountryPopulation> getCountryPopulationReport() {

        List<CountryPopulation> report = new ArrayList<>();

        String sql = """
                SELECT
                    co.Name,
                    co.Population,
                    COALESCE(SUM(ci.Population), 0) AS CityPopulation,
                    (co.Population - COALESCE(SUM(ci.Population), 0)) AS RuralPopulation
                FROM country co
                LEFT JOIN city ci
                    ON co.Code = ci.CountryCode
                GROUP BY
                    co.Code,
                    co.Name,
                    co.Population
                ORDER BY
                    co.Population DESC;
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                CountryPopulation countryPopulation = new CountryPopulation(
                        resultSet.getString("Name"),
                        resultSet.getLong("Population"),
                        resultSet.getLong("CityPopulation"),
                        resultSet.getLong("RuralPopulation"));

                report.add(countryPopulation);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving country population report.");
            e.printStackTrace();
        }

        return report;
    }

    public long getWorldPopulation() {
        long worldPopulation = 0;

        String sql = "SELECT SUM(Population) AS WorldPopulation FROM country";

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                worldPopulation = resultSet.getLong("WorldPopulation");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving world population.");
            e.printStackTrace();
        }

        return worldPopulation;
    }

    public long getContinentPopulation(String continent) {
        long continentPopulation = 0;

        String sql = "SELECT SUM(Population) AS ContinentPopulation FROM country WHERE Continent = ?";

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, continent);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    continentPopulation = resultSet.getLong("ContinentPopulation");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for continent: " + continent);
            e.printStackTrace();
        }

        return continentPopulation;
    }

    public long getRegionPopulation(String region) {
        long regionPopulation = 0;

        String sql = "SELECT SUM(Population) AS RegionPopulation FROM country WHERE Region = ?";

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, region);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    regionPopulation = resultSet.getLong("RegionPopulation");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for region: " + region);
            e.printStackTrace();
        }

        return regionPopulation;
    }

    public long getCountryPopulation(String country) {
        long countryPopulation = 0;

        String sql = "SELECT Population FROM country WHERE Name = ?";

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, country);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    countryPopulation = resultSet.getLong("Population");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for country: " + country);
            e.printStackTrace();
        }

        return countryPopulation;
    }

    public long getDistrictPopulation(String district) {
        long districtPopulation = 0;

        String sql = "SELECT SUM(Population) AS DistrictPopulation FROM city WHERE District = ?";

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, district);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    districtPopulation = resultSet.getLong("DistrictPopulation");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for district: " + district);
            e.printStackTrace();
        }

        return districtPopulation;
    }

    public long getCityPopulation(String city) {
        long cityPopulation = 0;

        String sql = "SELECT Population FROM city WHERE Name = ?";

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, city);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    cityPopulation = resultSet.getLong("Population");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for city: " + city);
            e.printStackTrace();
        }

        return cityPopulation;
    }
}