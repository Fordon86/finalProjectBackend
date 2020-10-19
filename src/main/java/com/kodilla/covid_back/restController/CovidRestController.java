package com.kodilla.covid_back.restController;

import com.kodilla.covid_back.client.CovidClient;
import com.kodilla.covid_back.dto.CovidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidRestController {

    @Autowired
    private CovidClient covidClient;

    @RequestMapping(method = RequestMethod.GET, value = "getCovidGrow")
    public List<CovidDto> getCovidGrow () {
        return covidClient.getCovidGrow();
    }

}
