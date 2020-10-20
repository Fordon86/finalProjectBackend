package com.kodilla.covid_back.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class UserFullViewDto {

    private Map<String, List<CovidDto>> mapCountryCovidGrow = new HashMap<>();
    private String userId;

}
