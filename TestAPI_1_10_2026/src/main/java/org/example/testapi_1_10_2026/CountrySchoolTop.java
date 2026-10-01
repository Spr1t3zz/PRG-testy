package org.example.testapi_1_10_2026;

public class CountrySchoolTop extends Country{

    private final double differenceFromYearAverage;

    public CountrySchoolTop(String country, String code, int year, double averageSchooling, double differenceFromYearAverage) {

        super(country, code, year, averageSchooling);
        this.differenceFromYearAverage = differenceFromYearAverage;
    }

    public double getDifferenceFromYearAverage() {
        return Math.round(differenceFromYearAverage * 100.0) / 100.0;
    }
}

