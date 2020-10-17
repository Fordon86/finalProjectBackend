package com.kodilla.covid_back.dao;

import com.kodilla.covid_back.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CountryDao extends CrudRepository<Country, Long> {
}
