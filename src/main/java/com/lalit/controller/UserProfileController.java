package com.lalit.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.constants.MessageConstant;
import com.lalit.constants.URLConstants;
import com.lalit.dto.UserProfileDto;
import com.lalit.mapper.UserProfileMapper;
import com.lalit.service.UserProfileService;
import com.lalit.utils.LPOResponse;
import com.lalit.utils.LocaleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="user profile related api's")
@RestController
public class UserProfileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileController.class);

	@Autowired
	UserProfileMapper userProfileMapper; 
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	LocaleService localeService;

	@ApiOperation(value="save the new user and update the extisting one")
	@PutMapping(URLConstants.USER_PROFILE)
	public ResponseEntity<LPOResponse> createOrUpdateUser(@RequestBody UserProfileDto userProfileDto,
			Long currentUserId){
		userProfileDto = userProfileService.createOrUpdateUser(userProfileDto,currentUserId);
		
		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.SAVED_SUCCESSFULLY))
						.data(userProfileDto, 1).build());
	}
	
	
	@ApiOperation(value =" getting the limited info of user and its spouse and child(MODIFIED)")
	@GetMapping(URLConstants.USER_LIMITED_DATA)
	public ResponseEntity<LPOResponse> getUserLimitedInfo(@PathVariable Long userId){
		Map<String, Object> data = userProfileService.getLimitedInfo(userId);
		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.FETCHED_SUCCESSFULLY))
				.data(data, 1).build());
	}
	
	
	@ApiOperation(value="Getting the Complete info About the User")
	@GetMapping(URLConstants.GET_USER_PROFILE)
	public ResponseEntity<LPOResponse> getProfile(@PathVariable Long userId){
		UserProfileDto userProfileDto = userProfileService.getUserProfile(userId);
		return ResponseEntity.ok(
				new LPOResponse.LPOResposeBuilder(false, localeService.getMessage(MessageConstant.FETCHED_SUCCESSFULLY))
				.data(userProfileDto, 1).build());
	}
	
}











