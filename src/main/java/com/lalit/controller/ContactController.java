package com.lalit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.constants.MessageConstant;
import com.lalit.constants.URLConstants;
import com.lalit.domain.Contact;
import com.lalit.dto.ChildDto;
import com.lalit.dto.SpouseDto;
import com.lalit.mapper.ContactMapper;
import com.lalit.service.ContactService;
import com.lalit.utils.LPOResponse;
import com.lalit.utils.LocaleService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	// @Autowired
	// ContactMapper contactMapper;

	@Autowired
	LocaleService localeService;

	@ApiOperation(value = "getting all details of all spouses")
	@GetMapping(URLConstants.SPOUSE)
	public ResponseEntity<LPOResponse> getSpouse(@PathVariable Long userId) {
		List<SpouseDto> spouseDto = contactService.getSpouse(userId).stream().map(ContactMapper::toSpouseDto)
				.collect(Collectors.toList());
		return ResponseEntity.ok(new LPOResponse.LPOResposeBuilder(false,
				localeService.getMessage(
						!spouseDto.isEmpty() ? MessageConstant.FETCHED_SUCCESSFULLY : MessageConstant.DATA_NOT_FOUND))
								.data(spouseDto, spouseDto.size()).build());
	}

	@ApiOperation(value = "getting all details of all children")
	@GetMapping(URLConstants.CHILD)
	public ResponseEntity<LPOResponse> getChildren(@PathVariable Long userId) {
		List<ChildDto> childDto = contactService.getChildren(userId).stream().map(ContactMapper::toChildDto)
				.collect(Collectors.toList());
		return ResponseEntity.ok(new LPOResponse.LPOResposeBuilder(false,
				localeService.getMessage(
						!childDto.isEmpty() ? MessageConstant.FETCHED_SUCCESSFULLY : MessageConstant.DATA_NOT_FOUND))
								.data(childDto, childDto.size()).build());
	}

}