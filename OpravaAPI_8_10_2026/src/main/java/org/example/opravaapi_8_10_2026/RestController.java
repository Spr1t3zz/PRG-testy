package org.example.opravaapi_8_10_2026;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/api/schooling/top-countries") //http://localhost:8080/api/schooling/top-countries?year=2020&min=10&limit=2
    public List<CountrySchoolTop> topCountries(     // UKOL 1
        @RequestParam int year,
        @RequestParam(required = false) Double min,
        @RequestParam(required = false) Integer limit
    ) {

        List<Country> countriesForTop = parseCsv().stream()
            .filter(country -> country.getYear() == year)
            .filter(country -> country.getCode().matches("[A-Z]{3}"))
            .toList();

        double averageSchooling = countriesForTop.stream()
            .mapToDouble(Country::getAverageSchooling)
            .average()
            .orElse(0);

        List<CountrySchoolTop> resultTopCountries = countriesForTop.stream()
            .filter(country -> min == null
                || country.getAverageSchooling() >= min)
            .map(country -> new CountrySchoolTop(
                country.getCountry(),
                country.getCode(),
                country.getYear(),
                country.getAverageSchooling(),
                country.getAverageSchooling() - averageSchooling
            ))
            .sorted((a, b) -> Double.compare(
                b.getAverageSchooling(),
                a.getAverageSchooling()
            ))
            .toList();

        if (limit != null && limit < resultTopCountries.size()) {
            resultTopCountries = resultTopCountries.subList(0, limit);
        }


        return resultTopCountries;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/api/schooling/stats") //http://localhost:8080/api/schooling/stats?year=2020 //UKOL 2
    public CountrySchoolStats schoolingStats(@RequestParam int year) { // UKOL 2

        List<Country> countriesForStat = parseCsv().stream()
            .filter(country -> country.getYear() == year)
            .filter(country -> country.getCode().matches("[A-Z]{3}"))
            .toList();

        return new CountrySchoolStats(countriesForStat, year);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/api/schooling/countries/{country}/change") //http://localhost:8080/api/schooling/countries/Czechia/change?from=1950&to=2020
    public CountrySchoolImprov getImprovement(                  // UKOL 3
        @PathVariable String country, @RequestParam int from, @RequestParam int to
    ) {

        List<Country> countries = parseCsv();

        Country fromCountry = countries.stream()
            .filter(c -> c.getCountry().equals(country))
            .filter(c -> c.getYear() == from)
            .filter(c -> c.getCode().matches("[A-Z]{3}"))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND
            ));

        Country toCountry = countries.stream()
            .filter(c -> c.getCountry().equals(country))
            .filter(c -> c.getYear() == to)
            .filter(c -> c.getCode().matches("[A-Z]{3}"))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND
            ));

        return new CountrySchoolImprov(
            fromCountry.getCountry(),
            fromCountry.getCode(),
            from,
            to,
            fromCountry.getAverageSchooling(),
            toCountry.getAverageSchooling()
        );
    }
    /// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private List<Country> parseCsv() {
        try {
            var inputStream = getClass().getClassLoader()
                .getResourceAsStream("mean-years-of-schooling-long-run.csv");

            if (inputStream == null) {
                throw new RuntimeException("CSV not found on classpath");
            }

            return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .skip(1)
                .map(row -> row.split(","))
                .map(row -> new Country(
                    row[0],
                    row[1],
                    Integer.parseInt(row[2]),
                    Double.parseDouble(row[3])
                ))
                .toList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
