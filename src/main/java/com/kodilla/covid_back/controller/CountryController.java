package com.kodilla.covid_back.controller;

import com.kodilla.covid_back.dto.CountryDto;
import com.kodilla.covid_back.mapper.CountryMapper;
import com.kodilla.covid_back.service.CountryDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/country")
public class CountryController {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountryDbService countryDbService;

    @PostMapping(value = "createCountry")
    public CountryDto createCountry (@RequestBody CountryDto countryDto) {
        return countryMapper.mapToCountryDto(countryDbService.saveCountry(countryMapper.mapToCountry(countryDto)));
    }

}

