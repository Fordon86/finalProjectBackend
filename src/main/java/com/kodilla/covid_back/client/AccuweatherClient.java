package com.kodilla.covid_back.client;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.dto.AccuweatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Component
public class AccuweatherClient {

    @Autowired
    private RestTemplate restTemplate;

    public AccuweatherDto getTemperature(Country country) {
        Object temperatureResponse = restTemplate.getForObject(
                "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" +
                        country.getCountryNumber() + "?apikey=Nx1o9A0Qevk0xShhhsGoG2e08AE7P7rd",
                Object.class);
        return convertToAccuweatherDto(temperatureResponse);
    }

    private AccuweatherDto convertToAccuweatherDto(Object object) {

        AccuweatherDto accuweatherDto = new AccuweatherDto();
        for (Object day: (ArrayList)((LinkedHashMap) object).get("DailyForecasts")) {
            Object dayTemperature = ((LinkedHashMap)day).get("Temperature");
        }

        /*AccuweatherDto accuweatherDto = new AccuweatherDto();
        for (Object day: (ArrayList)((LinkedHashMap) object).get("DailyForecasts")) {
            for (Object dayTemperature: (ArrayList)((LinkedHashMap)day).get("Temperature")) {
                dayTemperature.
            }
        }*/

        return accuweatherDto;
    }

}