package com.kodilla.covid_back.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private Long countryId;
    private String countryName;
    private String countryShortName;
    private int countryNumber;

}
