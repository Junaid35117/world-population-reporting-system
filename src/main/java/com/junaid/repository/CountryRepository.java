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
import com.junaid.model.PopulationReport;

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
                       Population,
                       Capital
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
                        resultSet.getInt("Population"),
                        resultSet.getString("Capital"));

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
                       Population,
                       Capital
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
                            resultSet.getInt("Population"),
                            resultSet.getString("Capital"));

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
                       Population,
                       Capital
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
                            resultSet.getInt("Population"),
                            resultSet.getString("Capital"));

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
                       Population,
                       Capital
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
                            resultSet.getInt("Population"),
                            resultSet.getString("Capital"));

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

    public PopulationReport getWorldPopulationReport() {

        String sql = """
                SELECT
                    'World' AS Name,
                    SUM(c.Population) AS TotalPopulation,
                    IFNULL(SUM(ci.Population),0) AS CityPopulation
                FROM country c
                LEFT JOIN city ci
                ON c.Code = ci.CountryCode
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery()) {

            if (rs.next()) {

                long total = rs.getLong("TotalPopulation");
                long city = rs.getLong("CityPopulation");
                long rural = total - city;

                double cityPercent = (city * 100.0) / total;
                double ruralPercent = (rural * 100.0) / total;

                return new PopulationReport(
                        rs.getString("Name"),
                        total,
                        city,
                        rural,
                        cityPercent,
                        ruralPercent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public PopulationReport getContinentPopulationReport(String continent) {

        String sql = """
                SELECT
                    c.Continent,
                    SUM(c.Population) AS TotalPopulation,
                    IFNULL(SUM(ci.Population),0) AS CityPopulation
                FROM country c
                LEFT JOIN city ci
                ON c.Code = ci.CountryCode
                WHERE c.Continent = ?
                GROUP BY c.Continent
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, continent);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                long total = rs.getLong("TotalPopulation");
                long city = rs.getLong("CityPopulation");
                long rural = total - city;

                return new PopulationReport(
                        continent,
                        total,
                        city,
                        rural,
                        city * 100.0 / total,
                        rural * 100.0 / total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public PopulationReport getRegionPopulationReport(String region) {

        String sql = """
                SELECT
                    c.Region AS Name,
                    SUM(c.Population) AS TotalPopulation,
                    IFNULL(SUM(ci.Population), 0) AS CityPopulation
                FROM country c
                LEFT JOIN city ci
                    ON c.Code = ci.CountryCode
                WHERE c.Region = ?
                GROUP BY c.Region
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, region);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {

                    long total = rs.getLong("TotalPopulation");
                    long city = rs.getLong("CityPopulation");
                    long rural = total - city;

                    return new PopulationReport(
                            rs.getString("Name"),
                            total,
                            city,
                            rural,
                            (city * 100.0) / total,
                            (rural * 100.0) / total);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for region: " + region);
            e.printStackTrace();
        }

        return null;
    }

    public PopulationReport getCountryPopulationReport(String country) {

        String sql = """
                SELECT
                    c.Name,
                    c.Population AS TotalPopulation,
                    IFNULL(SUM(ci.Population),0) AS CityPopulation
                FROM country c
                LEFT JOIN city ci
                    ON c.Code = ci.CountryCode
                WHERE c.Name = ?
                GROUP BY c.Code
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, country);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {

                    long total = rs.getLong("TotalPopulation");
                    long city = rs.getLong("CityPopulation");
                    long rural = total - city;

                    return new PopulationReport(
                            rs.getString("Name"),
                            total,
                            city,
                            rural,
                            (city * 100.0) / total,
                            (rural * 100.0) / total);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for country: " + country);
            e.printStackTrace();
        }

        return null;
    }

    public PopulationReport getDistrictPopulationReport(String district) {

        String sql = """
                SELECT
                    District AS Name,
                    SUM(Population) AS TotalPopulation
                FROM city
                WHERE District = ?
                GROUP BY District
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, district);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {

                    long total = rs.getLong("TotalPopulation");

                    return new PopulationReport(
                            rs.getString("Name"),
                            total,
                            total,
                            0,
                            100.0,
                            0.0);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for district: " + district);
            e.printStackTrace();
        }

        return null;
    }

    public PopulationReport getCityPopulationReport(String city) {

        String sql = """
                SELECT
                    Name,
                    Population
                FROM city
                WHERE Name = ?
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, city);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {

                    long total = rs.getLong("Population");

                    return new PopulationReport(
                            rs.getString("Name"),
                            total,
                            total,
                            0,
                            100.0,
                            0.0);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving population for city: " + city);
            e.printStackTrace();
        }

        return null;
    }
}