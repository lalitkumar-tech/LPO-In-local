package com.lalit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalit.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
