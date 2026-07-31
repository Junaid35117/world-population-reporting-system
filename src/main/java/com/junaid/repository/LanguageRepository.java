package com.junaid.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.junaid.database.DatabaseConnection;
import com.junaid.model.LanguageReport;

public class LanguageRepository {

    private final DatabaseConnection databaseConnection;

    public LanguageRepository() {
        databaseConnection = new DatabaseConnection();
    }

    public List<LanguageReport> getLanguageReport() {

        List<LanguageReport> reports = new ArrayList<>();

        String sql = """
                SELECT
                    cl.Language,

                    CAST(SUM(c.Population * cl.Percentage / 100) AS UNSIGNED) AS Speakers,

                    (
                        SUM(c.Population * cl.Percentage / 100)
                        /
                        (SELECT SUM(Population) FROM country)
                    ) * 100 AS Percentage

                FROM countrylanguage cl

                JOIN country c
                    ON cl.CountryCode = c.Code

                WHERE cl.Language IN
                (
                    'Chinese',
                    'English',
                    'Hindi',
                    'Spanish',
                    'Arabic'
                )

                GROUP BY cl.Language

                ORDER BY Speakers DESC
                """;

        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                LanguageReport report = new LanguageReport(
                        resultSet.getString("Language"),
                        resultSet.getLong("Speakers"),
                        resultSet.getDouble("Percentage"));

                reports.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }
}