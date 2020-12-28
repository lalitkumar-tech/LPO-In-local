package com.lalit.util.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.domain.Country;
import com.lalit.domain.State;
import com.lalit.exception.DataNotFoundException;
import com.lalit.repository.CountryRepository;
import com.lalit.repository.StateRepository;
import com.lalit.utils.LocaleService;

@Service
public class RegionService {

	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	LocaleService localeService;
	
	public List<Country> getCountriesList() {
		return countryRepo.findAll();
	}

	public List<State> findByCountryId(Long countryId) throws DataNotFoundException {
		List<State> statesByCountryId =  stateRepo.findByCountryId(countryId);
		if(statesByCountryId.isEmpty()){
			throw new DataNotFoundException(localeService.getMessage("no state found for seleted country"));
		}
		return statesByCountryId;
	}

}
