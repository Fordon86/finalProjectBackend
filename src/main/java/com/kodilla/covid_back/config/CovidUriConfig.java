package com.kodilla.covid_back.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CovidUriConfig {

    @Value("${covid.api.endpoint.prod}")
    private String covidApiEndpint;
}
