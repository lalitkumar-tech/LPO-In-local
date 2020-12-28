package com.lalit.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.constants.AppConstants;
import com.lalit.domain.Contact;
import com.lalit.enums.RelationType;
import com.lalit.repository.ContactRepository;

@Service
public class ContactServiceSecond {

	@Autowired
	ContactRepository contactRepository;

	public void updateSpouseEmail(Long userId, String email) {
		List<Contact> spouses = contactRepository.findByUserIdAndRelationInAndDeletedFalse(userId,
				Arrays.asList(RelationType.HUSBAND, RelationType.WIFE));
		spouses.forEach(spouse -> spouse.setEmail(email));
		contactRepository.saveAll(spouses);
	}

	public List<Contact> getContactLimitedInfo(Map<String, Object> data, Long userId) {
		List<Contact> childSpouseInfo = contactRepository.findByUserIdAndDeletedFalse(userId);
		return childSpouseInfo;

	}

}
