package com.lalit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.domain.Contact;
import com.lalit.dto.ChildDto;
import com.lalit.dto.SpouseDto;
import com.lalit.enums.RelationType;
import com.lalit.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactRepo;

	public List<Contact> getSpouse(Long userId) {
		List<Contact> spouses = contactRepo.findByUserIdAndRelationInAndDeletedFalse(userId,RelationType.spouseList);
		return spouses;
	}

	public List<Contact> getChildren(Long userId) {
		List<Contact> children = contactRepo.findByUserIdAndRelationInAndDeletedFalse(userId, RelationType.children);
		return children;
	}

	
}
