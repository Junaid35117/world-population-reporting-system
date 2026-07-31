package com.junaid.service;

import java.util.List;

import com.junaid.model.LanguageReport;
import com.junaid.repository.LanguageRepository;

public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService() {
        languageRepository = new LanguageRepository();
    }

    public List<LanguageReport> getLanguageReport() {
        return languageRepository.getLanguageReport();
    }
}