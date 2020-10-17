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
        return new CountryDto(
                country.getCountryId(),
                country.getCountryName(),
                country.getCountryShortName(),
                country.getCountryNumber());
    }

    public List<CountryDto> mapToCountryDtoList (final List<Country> countryList) {
        return countryList.stream()
                .map(t -> new CountryDto(t.getCountryId(),
                        t.getCountryName(),
                        t.getCountryShortName(),
                        t.getCountryNumber()))
                .collect(Collectors.toList());
    }

}
