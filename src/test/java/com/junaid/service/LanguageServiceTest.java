package com.junaid.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junaid.model.LanguageReport;

class LanguageServiceTest {

    private LanguageService languageService;

    @BeforeEach
    void setUp() {
        languageService = new LanguageService();
    }

    @Test
    void shouldReturnLanguageReport() {

        List<LanguageReport> reports = languageService.getLanguageReport();

        assertNotNull(reports);
        assertEquals(5, reports.size());
    }

}