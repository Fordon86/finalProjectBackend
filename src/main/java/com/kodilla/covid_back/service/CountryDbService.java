package com.kodilla.covid_back.service;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryDbService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountry () {
        return countryRepository.findAll();
    }

    public void deleteCountry (final Long countryId) {
        countryRepository.deleteById(countryId);
    }

    public Optional<Country> getCountry (final Long countryId) {
        return countryRepository.findById(countryId);
    }

    public Country saveCountry (Country country) {
        return countryRepository.save(country);
    }

}
