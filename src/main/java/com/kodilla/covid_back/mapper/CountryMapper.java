package com.kodilla.covid_back.mapper;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.dto.CountryDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    public Country mapToCountry (final CountryDto countryDto) {
        return Country.builder().countryId(countryDto.getCountryId())
                .countryName(countryDto.getCountryName())
                .countryShortName(countryDto.getCountryShortName())
                .countryNumber(countryDto.getCountryNumber())
                .build();
    }

    public CountryDto mapToCountryDto (final Country country) {
        return CountryDto.builder()
                .countryId(country.getCountryId())
                .countryName((country.getCountryName()))
                .countryNumber(country.getCountryNumber())
                .countryShortName(country.getCountryShortName())
                .build();
    }

    public List<CountryDto> mapToCountryDtoList (final List<Country> countryList) {
        return countryList.stream()
                .map(country -> CountryDto.builder()
                        .countryId(country.getCountryId())
                        .countryName((country.getCountryName()))
                        .countryNumber(country.getCountryNumber())
                        .countryShortName(country.getCountryShortName())
                        .build())
                        .collect(Collectors.toList());
    }

}
