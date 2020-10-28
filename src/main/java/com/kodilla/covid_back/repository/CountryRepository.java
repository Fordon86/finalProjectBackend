package com.kodilla.covid_back.repository;

import com.kodilla.covid_back.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository <Country, Long> {
   @Override
   List<Country> findAll();

    @Override
    void deleteById(Long Id);

}