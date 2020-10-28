package com.kodilla.covid_back.domain;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER")
public class User {

    private Long userId;
    private String userName;
    private String userPassword;
    private List<Country> countries = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    public Long getUserId(){
        return userId;
    };

    @NotNull
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    @NotNull
    @Column(name = "USER_PASSWORD")
    public String getUserPassword() {
        return userPassword;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COUNTRY_USER",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")}
    )
    public List<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void deleteCountry(Country country) {
        countries.remove(country);
    }
}