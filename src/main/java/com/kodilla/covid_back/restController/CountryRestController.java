package com.kodilla.covid_back.restController;

import com.kodilla.covid_back.dto.CountryDto;
import com.kodilla.covid_back.mapper.CountryMapper;
import com.kodilla.covid_back.service.CountryDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CountryRestController {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountryDbService countryDbService;

    @RequestMapping(value = "getCountryList")
    public List<CountryDto> getCountryList() {
        return countryMapper.mapToCountryDtoList(countryDbService.getCountry());
    }

}
