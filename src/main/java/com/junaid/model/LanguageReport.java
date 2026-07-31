package com.junaid.model;

public class LanguageReport {

    private String language;
    private long speakers;
    private double percentage;

    public LanguageReport() {
    }

    public LanguageReport(String language, long speakers, double percentage) {
        this.language = language;
        this.speakers = speakers;
        this.percentage = percentage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getSpeakers() {
        return speakers;
    }

    public void setSpeakers(long speakers) {
        this.speakers = speakers;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}