package org.example.testapi_1_10_2026;

public class Country {

    private final String country;
    private final String code;
    private final int year;
    private final double averageSchooling;

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getYear() {
        return year;
    }

    public double getAverageSchooling() {
        return averageSchooling;
    }

    public Country(String country, String code, int year, double AverageSchooling) {
        this.country = country;
        this.code = code;
        this.year = year;
        this.averageSchooling = AverageSchooling;
    }
}

