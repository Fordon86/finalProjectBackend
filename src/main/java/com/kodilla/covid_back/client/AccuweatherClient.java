package com.kodilla.covid_back.client;

import com.kodilla.covid_back.dto.AccuweatherDto;
import com.kodilla.covid_back.dto.CovidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccuweatherClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<AccuweatherDto> getTemperature() {
        AccuweatherDto[] temperatureResponse = restTemplate.getForObject(
                "http://dataservice.accuweather.com/forecasts/v1/daily/1day/274663?apikey=Nx1o9A0Qevk0xShhhsGoG2e08AE7P7rd",
                AccuweatherDto[].class);
        if (temperatureResponse != null) {
            return Arrays.asList(temperatureResponse);
        }
        return new ArrayList<>();
    }

}
