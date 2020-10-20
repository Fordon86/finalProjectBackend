package com.kodilla.covid_back.client;

import com.kodilla.covid_back.config.CovidUriConfig;
import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.dto.CovidDto;
import com.kodilla.covid_back.service.CountryDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class CovidClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<CovidDto> getCovidGrow(Country country) {
        CovidDto[] covidResponse = restTemplate.getForObject(
                "https://covid19-api.org/api/prediction/" + country.getCountryShortName(),
                CovidDto[].class);
        if (covidResponse != null) {
            return Arrays.asList(covidResponse);
        }
        return new ArrayList<>();
    }

}
