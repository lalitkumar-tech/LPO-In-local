package com.lalit.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.constants.MessageConstant;
import com.lalit.domain.Contact;
import com.lalit.domain.User;
import com.lalit.dto.ChildDto;
import com.lalit.dto.FiduciaryDto;
import com.lalit.dto.SpouseDto;
import com.lalit.enums.AccountType;
import com.lalit.enums.BeneficiaryType;
import com.lalit.enums.RelationType;
import com.lalit.exception.DataNotFoundException;
import com.lalit.mapper.ContactMapper;
import com.lalit.mapper.EmergencyMapper;
import com.lalit.repository.ContactRepository;
import com.lalit.repository.UserRepository;
import com.lalit.utils.LocaleService;


@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactRepo;

	@Autowired
	ContactMapper contactMapper;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EmergencyMapper emergencyMapper;
	
	@Autowired
	LocaleService localeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactService.class);
	public List<Contact> getSpouse(Long userId) {
		List<Contact> spouses = contactRepo.findByUserIdAndRelationInAndDeletedFalse(userId,RelationType.spouseList);
		return spouses;
	}

	public List<Contact> getChildren(Long userId) {
		List<Contact> children = contactRepo.findByUserIdAndRelationInAndDeletedFalse(userId, RelationType.children);
		return children;
	}

	//for adding and updating the spouse
	public SpouseDto addSpouse(SpouseDto spouseDto) {
		
		LOGGER.info("==============add and update Spouse =======================");
		Contact spouse = contactMapper.toSpouse(spouseDto);
		spouse = contactRepo.saveAndFlush(spouse);
		updateUserFieldsOnSpouseModification(spouse);
		if (spouse.getIsEmergencyContact() != null && spouse.getIsEmergencyContact()) {
			emergencyMapper.updateEmergencyContactForClient(spouse);
		}
		spouseDto.setId(spouse.getId());
		return spouseDto;
	}                                     
	
	private void updateUserFieldsOnSpouseModification(Contact spouse){
		LOGGER.info("=====================updating user field on spouse modifi.==============");
		User user = spouse.getUser();
		user.setAccountType(StringUtils.equalsIgnoreCase(user.getEmail(), spouse.getEmail()) ?
				AccountType.JOINT : AccountType.SEPERATE);
		userRepo.save(user);
	}

	public void deleteContact(Long userId, Long contactId) {
		Contact contact = contactRepo.findByIdAndUserIdAndDeletedFalse(contactId,userId);
		if(Objects.isNull(contact)){
			throw DataNotFoundException.of(MessageConstant.CONTACT_NOT_FOUND);
		}
		contact.setDeleted(true);
		contact.setDeletedOn(new Date());
		contact = contactRepo.save(contact);
		if (contact.getIsEmergencyContact() != null && contact.getIsEmergencyContact()) {
			emergencyMapper.deleteEmergencyContactForClient(contact);
		}
	}

	public ChildDto addChild(ChildDto childDto) {
		Contact child = contactMapper.tochild(childDto);
		child = contactRepo.saveAndFlush(child);
		if (child.getIsEmergencyContact() != null && child.getIsEmergencyContact()) {
			emergencyMapper.updateEmergencyContactForClient(child);
		}
		childDto.setId(child.getId());
		return childDto;
	}

	public List<Contact> getAllContacts(Long userId) {
		LOGGER.info("=================getting all contacts============");
		List<Contact> contacts = contactRepo.findByUserIdAndDeletedFalse(userId);
		return contacts;
	}

	public FiduciaryDto addContact(FiduciaryDto contactDto) {
		LOGGER.info("================under addContact()==========");
		Contact contact = contactMapper.toFiduciary(contactDto, contactDto.getIsFiduciary(),
				contactDto.getIsBeneficiary());
		contact.setBeneficiaryType(BeneficiaryType.INDIVIDUAL);
		contact = contactRepo.save(contact);
		contactDto.setId(contact.getId());
		return contactDto;
	}
	


	
}
