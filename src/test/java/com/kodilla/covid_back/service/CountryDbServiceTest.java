package com.kodilla.covid_back.service;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.repository.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryDbServiceTest {

    @InjectMocks
    private CountryDbService countryDbService;

    @Mock
    private CountryRepository countryRepository;

    @Test
    public void getCountryTest() {
        //Given
        List<Country> countryList = new ArrayList<>();
        Country country1 = mock(Country.class);
        Country country2 = mock(Country.class);
        Country country3 = mock(Country.class);
        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        when(countryRepository.findAll()).thenReturn(countryList);

        //When
        List<Country> result = countryDbService.getCountry();

        //Then
        assertEquals(countryList.size(), result.size());
    }

    @Test
    public void getCountrysTest() {
        //Given
        Country country1 = mock(Country.class);

        when(countryRepository.findById(2L)).thenReturn(Optional.of(country1));
        Optional<Country> result = countryDbService.getCountry(2L);

        //When & Then
        assertEquals(country1, result.get());
    }

    @Test
    public void seveCountryTest() {
        //Given
        Country country1 = new Country();
        when(countryRepository.save(country1)).thenReturn(country1);

        //When
        Country result = countryDbService.saveCountry(country1);

        //Then
        assertEquals(country1, result);
    }
}