package com.lalit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.constants.AppConstants;
import com.lalit.constants.MessageConstant;
import com.lalit.domain.Contact;
import com.lalit.domain.User;
import com.lalit.dto.UserProfileDto;
import com.lalit.enums.AccountType;
import com.lalit.enums.RelationType;
import com.lalit.exception.DataNotFoundException;
import com.lalit.mapper.UserProfileMapper;
import com.lalit.repository.ContactRepository;
import com.lalit.repository.UserRepository;
import com.lalit.utils.LocaleService;

@Service
public class UserProfileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileService.class);

	@Autowired
	UserProfileMapper userProfileMapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ContactServiceSecond contactServiceSecond;

	@Autowired
	LocaleService localService;

	@Autowired
	ContactRepository contactRepository;
	
	public UserProfileDto createOrUpdateUser(UserProfileDto userProfileDto, Long currentUserId) {
		userProfileDto.setUserId(currentUserId);
		User user = userProfileMapper.toUser(userProfileDto, currentUserId);
		user.setAccountExpired(false);
		user.setAccountNonLocked(true);
		user.setEnabled(true);

		user = userRepository.save(user);

		if (AccountType.JOINT == user.getAccountType()) {
			LOGGER.info("=========spouse id must be same as user if acc.type is joint=========");
			contactServiceSecond.updateSpouseEmail(user.getId(), user.getEmail());
		}

		userProfileDto = userProfileMapper.toUserProfileDto(user);
		return userProfileDto;
	}

	public Map<String, Object> getLimitedInfo(Long userId) {
		Map<String, Object> data = new HashMap<>();
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw DataNotFoundException.of(localService.getMessage(MessageConstant.USER_ID_INVALID));
		} else {
			User userInfo = user.get();
			data.put("userId", userId);
			data.put(AppConstants.FIRST_NAME, userInfo.getFirstName());
			data.put(AppConstants.MIDDLE_NAME, userInfo.getMiddleName());
			data.put(AppConstants.LAST_NAME, userInfo.getLastName());
			data.put(AppConstants.CONTACT_EMAIL, userInfo.getEmail());
			List<Contact> childContacts = contactRepository.findByUserIdAndRelationInAndDeletedFalse(userId,RelationType.children);
			List<Contact> spouseContacts = contactRepository.findByUserIdAndRelationInAndDeletedFalse(userId,RelationType.spouseList);
			List<Map<String, Object>> childInfo  =  addContactInfo(childContacts);
			List<Map<String, Object>> spouseInfo  =  addContactInfo(spouseContacts);
			data.put("Spouses", spouseInfo);
			data.put("Children", childInfo);

		}
		return data;
	}

	private List<Map<String, Object>> addContactInfo(List<Contact> childSpouseContacts) {
		List<Map<String, Object>> contacts = childSpouseContacts.stream().map(contact -> {
			Map<String, Object> map = new HashMap<>();
			map.put(AppConstants.CONTACT_ID, contact.getId());
			map.put(AppConstants.FIRST_NAME, contact.getFirstName());
			map.put(AppConstants.MIDDLE_NAME, contact.getMiddleName());
			map.put(AppConstants.LAST_NAME, contact.getLastName());
			map.put(AppConstants.CONTACT_EMAIL, contact.getEmail());
			map.put(AppConstants.RELATION, contact.getRelation());

			return map;
		}).collect(Collectors.toList());
		return contacts;
	}

	public UserProfileDto getUserProfile(Long userId) {
		UserProfileDto userProfileDto = null;
		Optional<User> userOpt = userRepository.findById(userId);
		if(userOpt.isPresent()){
			userProfileDto=userProfileMapper.toUserProfileDto(userOpt.get());
		}
		return userProfileDto;
	}

}
