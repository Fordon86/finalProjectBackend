package com.kodilla.covid_back.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CovidDto {

    private String country;
    private String date;
    private int cases;

}