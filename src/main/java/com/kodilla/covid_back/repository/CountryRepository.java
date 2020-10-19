package com.kodilla.covid_back.repository;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository <Country, Long> {
   @Override
   List<Country> findAll();

    @Override
    void deleteById(Long Id);

/*    @Override
    Optional<User> findById(Long Id);*/

/*    @Override
    User save(Country country);*/

}
