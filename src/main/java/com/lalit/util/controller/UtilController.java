package com.lalit.util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.constants.MessageConstant;
import com.lalit.constants.URLConstants;
import com.lalit.util.service.RegionService;
import com.lalit.utils.LPOResponse;
import com.lalit.utils.LocaleService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UtilController {
	@Autowired
	LocaleService localeService;

	@Autowired
	RegionService regionService;

	@ApiOperation(value = "getting all the Countries")
	@GetMapping(URLConstants.COUNTRIES)
	public ResponseEntity<LPOResponse> getAllCountries() {
		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.FETCHED_SUCCESSFULLY))
						.data(regionService.getCountriesList(), 10).build());
	}

	@ApiOperation(value = "getting all states by country id")
	@GetMapping(URLConstants.STATES)
	public ResponseEntity<LPOResponse> getAllStatesForCountry(@PathVariable Long countryId) {
		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.FETCHED_SUCCESSFULLY))
						.data(regionService.findByCountryId(countryId), 10).build());
	}
}
