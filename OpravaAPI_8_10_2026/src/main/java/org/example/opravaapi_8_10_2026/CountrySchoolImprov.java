package org.example.opravaapi_8_10_2026;

public class CountrySchoolImprov {

    private final String country;
    private final String code;
    private final int fromYear;
    private final int toYear;
    private final double schoolFrom;
    private final double schoolTo;

    public CountrySchoolImprov(
        String country,
        String code,
        int fromYear,
        int toYear,
        double schoolFrom,
        double schoolTo
    ) {
        this.country = country;
        this.code = code;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.schoolFrom = schoolFrom;
        this.schoolTo = schoolTo;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getFromYear() {
        return fromYear;
    }

    public int getToYear() {
        return toYear;
    }

    public double getSchoolFrom() {
        return round(schoolFrom);
    }

    public double getSchoolTo() {
        return round(schoolTo);
    }

    public double getSchoolChange() {
        return round(schoolTo - schoolFrom);
    }

    public double getSchoolPercent() {
        return round(
            (schoolTo - schoolFrom)
                / schoolFrom * 100
        );
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
