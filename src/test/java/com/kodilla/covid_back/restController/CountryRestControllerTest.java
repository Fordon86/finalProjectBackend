package com.kodilla.covid_back.restController;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.dto.CountryDto;
import com.kodilla.covid_back.mapper.CountryMapper;
import com.kodilla.covid_back.service.CountryDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryRestControllerTest {

    @InjectMocks
    private CountryRestController countryRestController;

    @Mock
    private CountryMapper countryMapper;

    @Mock
    private CountryDbService countryDbService;

    @Test
    public void getCountryListTest() {
        //Given
        List<Country> countryList = new ArrayList<>();
        Country country = mock(Country.class);
        countryList.add(country);

        List<CountryDto> countryDtoList = new ArrayList<>();
        CountryDto countryDto = mock(CountryDto.class);
        countryDtoList.add(countryDto);

        when(countryDbService.getCountry()).thenReturn(countryList);
        when(countryMapper.mapToCountryDtoList(countryList)).thenReturn(countryDtoList);

        //When
        List<CountryDto> result = countryRestController.getCountryList();

        //Then
        assertEquals(result, countryDtoList);
    }

}