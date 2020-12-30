package com.lalit.mapper;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lalit.domain.Contact;
import com.lalit.domain.EmergencyContact;
import com.lalit.enums.EmergencyContactFor;
import com.lalit.repository.EmergencyContactRepository;
import com.lalit.repository.EmergencyRepository;




@Component 
public class EmergencyMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmergencyMapper.class);
	@Autowired
	private EmergencyRepository emergencyRepository;
	
	@Autowired
	private EmergencyContactRepository emergencyContactRepository;
	
	public void updateEmergencyContactForClient(Contact contact) {
		LOGGER.info("=================update emergency contact for client ===================");
		
		EmergencyContact emergencyContact = emergencyContactRepository
				.findByUserIdAndEmergencyContactIdAndEmergencyContactForAndDeletedFalse(contact.getUser().getId(),
						contact.getId(), EmergencyContactFor.CLIENT)
				.orElse(new EmergencyContact());
		emergencyContact.setUser(contact.getUser());
		emergencyContact.setEmergencyContact(contact);
		emergencyContact.setEmergencyContactFor(EmergencyContactFor.CLIENT);
		emergencyContact.setRelation(contact.getRelation());
		emergencyContactRepository.save(emergencyContact);
	}

	public void deleteEmergencyContactForClient(Contact contact) {
		LOGGER.info("=================deleting emergency contact for client ===================");
		Optional<EmergencyContact> emergencyContactOptional = emergencyContactRepository
				.findByUserIdAndEmergencyContactIdAndEmergencyContactForAndDeletedFalse(contact.getUser().getId(),
						contact.getId(), EmergencyContactFor.CLIENT);
		if (emergencyContactOptional.isPresent()) {
			EmergencyContact emergencyContact = emergencyContactOptional.get();
			emergencyContact.setDeleted(true);
			emergencyContact.setDeletedOn(new Date());
			emergencyContactRepository.save(emergencyContact);
		}
	}
}

//findByUserIdAndEmergencyContactIdAndEmergencyContactForAndDeletedFalse
