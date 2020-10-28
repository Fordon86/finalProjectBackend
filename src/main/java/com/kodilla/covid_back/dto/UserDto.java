package com.kodilla.covid_back.dto;

import lombok.*;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String userName;
    private String userPassword;
    private List<CountryDto> userCountryList;

}