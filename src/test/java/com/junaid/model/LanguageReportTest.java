package com.junaid.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LanguageReportTest {

    LanguageReport report = new LanguageReport("English", 500000000, 8.2);

    @Test
    void constructorShouldSetValues() {
        assertEquals("English", report.getLanguage());
        assertEquals(500000000, report.getSpeakers());
        assertEquals(8.2, report.getPercentage());
    }
}
