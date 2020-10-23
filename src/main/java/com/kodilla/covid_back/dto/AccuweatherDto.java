package com.kodilla.covid_back.dto;

import com.kodilla.covid_back.client.AccuweatherClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class AccuweatherDto {

    @Autowired
    AccuweatherClient accuweatherClient;

    private String day;
    private int temperature;

    private Map<String, Integer> accuweatherData = new HashMap<>();


}
