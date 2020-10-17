package com.kodilla.covid_back.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccuweatherDto {

    private String country;
    private String date;
    private int temperature;

}
