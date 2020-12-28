package com.lalit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalit.domain.State;

public interface StateRepository extends JpaRepository<State, Long>{

	List<State> findByCountryId(Long countryId);

}
