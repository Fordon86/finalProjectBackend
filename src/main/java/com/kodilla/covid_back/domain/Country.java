package com.kodilla.covid_back.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COUNTRY")
public class Country {

    private Long countryId;
    private String countryName;
    private String countryShortName;
    private int countryNumber;
    private List<User> users = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COUNTRY_ID", unique = true)
    public Long getCountryId() {
        return countryId;
    }

    @NotNull
    @Column(name = "COUNTRY_NAME")
    public String getCountryName() {
        return countryName;
    }

    @NotNull
    @Column(name = "COUNTRY_SHORT_NAME")
    public String getCountryShortName() {
        return countryShortName;
    }

    @NotNull
    @Column(name = "COUNTRY_NUMBER")
    public int getCountryNumber() {
        return countryNumber;
    }

    @ManyToMany(cascade = CascadeType.ALL,
    mappedBy = "COUNTRY")
    public List<User> getUsers() {
        return users;
    }



}
