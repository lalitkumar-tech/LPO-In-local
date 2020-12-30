package com.lalit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.constants.MessageConstant;
import com.lalit.constants.URLConstants;
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

	@Autowired
	LocaleService localeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

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

	@ApiOperation(value = "Adding or updating the spouse ")
	@PostMapping(URLConstants.SPOUSE)
	public ResponseEntity<LPOResponse> addSpouse(@PathVariable Long userId, SpouseDto spouseDto) throws Exception {
		LOGGER.info("===============setting the SpouseId of spouseDto to userId==============");
		spouseDto.setSpouseId(userId);
		spouseDto = contactService.addSpouse(spouseDto);

		// Skipped the profile photo upload functionality

		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.FETCHED_SUCCESSFULLY))
						.data(spouseDto, 1).build());
	}

	@ApiOperation(value = "Deleting the contact through contactId")
	@DeleteMapping(URLConstants.DELETE_CONTACT)
	public ResponseEntity<LPOResponse> deleteContact(@PathVariable Long contactId, @PathVariable Long userId) {
		contactService.deleteContact(userId, contactId);

		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.DELETED_SUCCESSFULLY))
						.data(null, 0).build());

	}

	@ApiOperation(value = "Adding or updating the child")
	@PostMapping(URLConstants.CHILD)
	public ResponseEntity<LPOResponse> addChildren(@PathVariable Long userId, ChildDto childDto) {
		childDto.setParentId(userId);
		childDto = contactService.addChild(childDto);
		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.SAVED_SUCCESSFULLY))
						.data(childDto, 1).build());
	}

}
