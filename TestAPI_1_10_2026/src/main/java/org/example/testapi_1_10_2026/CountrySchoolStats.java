package org.example.testapi_1_10_2026;

import java.util.List;

public class CountrySchoolStats {
    private final List<Country> countries;
    private final int year;

    public CountrySchoolStats(List<Country> countries, int year) {
        this.countries = countries;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getCountryCount() {
        return countries.size();
    }

    public double getAvgSchool() {
        double avg = countries.stream()
            .mapToDouble(Country::getAverageSchooling)
            .average()
            .orElse(0);

        return round(avg);
    }

    public double getMaxSchool() {
        double max = countries.stream()
            .mapToDouble(Country::getAverageSchooling) 
            .max()
            .orElse(0);

        return round(max);
    }

    public double getMinSchool() {
        double min = countries.stream()
            .mapToDouble(Country::getAverageSchooling)
            .min()
            .orElse(0);

        return round(min);
    }

    public String getMaxSchoolCountry() {
        return countries.stream()
            .max((a, b) -> Double.compare(
                a.getAverageSchooling(),
                b.getAverageSchooling()
            ))
            .map(Country::getCountry)
            .orElse(null);
    }

    public String getMinSchoolCountry() {
        return countries.stream()
            .min((a, b) -> Double.compare(
                a.getAverageSchooling(),
                b.getAverageSchooling()
            ))
            .map(Country::getCountry)
            .orElse(null);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
