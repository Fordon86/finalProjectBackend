package com.kodilla.covid_back.controller;

import com.kodilla.covid_back.client.AccuweatherClient;
import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.dto.AccuweatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccuweatherController {
/*
    @Autowired
    private AccuweatherClient accuweatherClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTemperature")
    public List<AccuweatherDto> getTemperature () {
        return accuweatherClient.getTemperature();
    }*/

}
