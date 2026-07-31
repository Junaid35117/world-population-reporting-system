package com.junaid.report;

import java.text.NumberFormat;
import java.util.List;

import com.junaid.model.LanguageReport;
import com.junaid.service.LanguageService;

public class LanguageReportPrinter {

    private final LanguageService languageService;

    public LanguageReportPrinter() {
        languageService = new LanguageService();
    }

    public void displayLanguageReport() {

        List<LanguageReport> reports = languageService.getLanguageReport();

        if (reports == null || reports.isEmpty()) {
            System.out.println("No language data found.");
            return;
        }

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println("==============================================================================");
        System.out.printf("%-20s %-20s %-20s%n",
                "Language",
                "Speakers",
                "World Percentage");
        System.out.println("==============================================================================");

        for (LanguageReport report : reports) {

            System.out.printf("%-20s %-20s %-19.2f%%%n",
                    report.getLanguage(),
                    formatter.format(report.getSpeakers()),
                    report.getPercentage());
        }

        System.out.println("==============================================================================");
    }
}