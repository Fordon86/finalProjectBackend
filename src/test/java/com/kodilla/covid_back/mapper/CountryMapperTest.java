package com.kodilla.covid_back.mapper;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.dto.CountryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CountryMapperTest {

    private CountryMapper countryMapper = new CountryMapper();

    @Test
    public void mapToCountryTest() {
        //Given
        CountryDto countryDto = new CountryDto(1L,"Poland", "PL", 12);

        //When
        Country country = countryMapper.mapToCountry(countryDto);

        //Then
        assertEquals(country.getCountryId(),countryDto.getCountryId());
        assertEquals(country.getCountryName(),countryDto.getCountryName());
        assertEquals(country.getCountryNumber(),countryDto.getCountryNumber());
        assertEquals(country.getCountryShortName(),countryDto.getCountryShortName());
    }

    @Test
    public void mapToCountryDtoTest() {
        //Given
        Country country = new Country(1L,"Poland", "PL", 2, null);

        //When
        CountryDto countryDto = countryMapper.mapToCountryDto(country);

        //Then
        assertEquals(countryDto.getCountryId(),country.getCountryId());
        assertEquals(countryDto.getCountryName(),country.getCountryName());
        assertEquals(countryDto.getCountryNumber(),country.getCountryNumber());
        assertEquals(countryDto.getCountryShortName(),country.getCountryShortName());
    }

    @Test
    public void mapToCountryDtoListTest() {
        //Given
        List<Country> countryList = new ArrayList<>();
        Country country = new Country(1L,"Poland", "PL", 2, null);
        countryList.add(country);

        //When
        List<CountryDto> countryDtoList = countryMapper.mapToCountryDtoList(countryList);

        //Then
        assertEquals(countryDtoList.get(0).getCountryId(),countryList.get(0).getCountryId());
        assertEquals(countryDtoList.get(0).getCountryName(),countryList.get(0).getCountryName());
        assertEquals(countryDtoList.get(0).getCountryNumber(),countryList.get(0).getCountryNumber());
        assertEquals(countryDtoList.get(0).getCountryShortName(),countryList.get(0).getCountryShortName());
    }
}
