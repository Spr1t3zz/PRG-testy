package org.example.testapi_1_10_2026;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController     //67%
public class RestController {
    @GetMapping("/api/schooling/top-countries") //http://localhost:8080/api/schooling/top-countries?year=2020&min=10
    public List<CountrySchoolTop> topCountries(     //UKOL 1
        @RequestParam int year,
        @RequestParam(required = false) Double min,
        @RequestParam(required = false) Integer limit
    ) {

        List<Country> countries = parseCsv().stream()
            .filter(country -> country.getYear() == year)
            .filter(country -> country.getCode().matches("[A-Z]{3}"))
            .toList();

        double averageSchool = countries.stream()
            .mapToDouble(Country::getAverageSchooling)
            .average()
            .orElse(0);

        List<CountrySchoolTop> resultTop = countries.stream()
            .filter(country -> min == null
                || country.getAverageSchooling() >= min)
            .map(country -> new CountrySchoolTop(
                country.getCountry(),
                country.getCode(),
                country.getYear(),
                country.getAverageSchooling(),
                country.getAverageSchooling() - averageSchool
            ))
            .sorted((a, b) -> Double.compare(
                b.getAverageSchooling(),
                a.getAverageSchooling()
            ))
            .toList();

        if (limit != null && limit < resultTop.size()) {
            resultTop = resultTop.subList(0, limit);
        }

        if (resultTop.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND
            );
        }

        return resultTop;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/api/schooling/stats") //http://localhost:8080/api/schooling/stats?year=2020 //UKOL 2
    public CountrySchoolStats schoolingStats(@RequestParam int year) {

        List<Country> statCountries = parseCsv().stream()
            .filter(country -> country.getYear() == year)
            .filter(country -> country.getCode().matches("[A-Z]{3}"))
            .toList();

        if (statCountries.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND
            );
        }

        return new CountrySchoolStats(statCountries, year);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//UKOL 3 CHYBU NEBO JE SPATNE NAPSANY
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
