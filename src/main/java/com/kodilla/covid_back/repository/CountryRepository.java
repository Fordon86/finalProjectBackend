package com.kodilla.covid_back.repository;

import com.kodilla.covid_back.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Long> {
/*    @Override
    List<Country> findAll();

    @Override
    void deleteById(Long Id);

    @Override
    Optional<User> findById(Long Id);

    @Override
    User save(Country country);*/

}
