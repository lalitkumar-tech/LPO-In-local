package com.lalit.mapper;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lalit.domain.Contact;
import com.lalit.domain.ContactOrganization;
import com.lalit.dto.FiduciaryDto;
import com.lalit.enums.RelationType;
import com.lalit.utils.GeneralUtils;

@Component
public class FiduciaryMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(FiduciaryMapper.class);
	
	public static FiduciaryDto toFiduciaryDto(Contact agent){
		LOGGER.info("======================converting the contact to FiduciaryDto ===================");

		FiduciaryDto fiduciary = new FiduciaryDto();
		fiduciary.setFirstName(agent.getFirstName());
		fiduciary.setMiddleName(agent.getMiddleName());
		fiduciary.setLastName(Objects.isNull(agent.getLastName()) ? "" : agent.getLastName());
		fiduciary.setNickName(agent.getNickName());
		fiduciary.setId(agent.getId());
		if (agent.getGender() != null) {
			fiduciary.setGender(agent.getGender().getValue());
		}
		copyAddressDetails(agent,fiduciary);
		fiduciary.setIsFiduciary(agent.getIsFiduciary());
		fiduciary.setIsBeneficiary(agent.getIsBeneficiary());
		fiduciary.setDob(Objects.isNull(agent.getDob()) ? null : GeneralUtils.getDateInFormat(agent.getDob()));
		fiduciary.setEmail(agent.getEmail());
		fiduciary.setSecondaryEmail(agent.getSecondaryEmail());
		fiduciary.setTertiaryEmail(agent.getTertiaryEmail());

		fiduciary.setPhoneNumber(agent.getPhoneNumber());
		fiduciary.setSecondaryMobileNumber(agent.getSecondaryMobileNumber());
		fiduciary.setTertiaryMobileNumber(agent.getTertiaryMobileNumber());

		fiduciary.setIsUsCitizen(agent.getIsUsCitizen());
		fiduciary.setSendGreeting(agent.getSendGreeting());

		fiduciary.setContactType(agent.getContactType());
		fiduciary.setContactGroup(agent.getContactGroup());
		setRelationText(fiduciary,agent);
		if (agent.getUser() != null) {
			fiduciary.setUserId(agent.getUser().getId());
		}

		fiduciary.setIsDeceased(agent.getIsDeceased());
		fiduciary.setIsHerChild(agent.getIsHerChild());
		fiduciary.setIsHisChild(agent.getIsHisChild());
		fiduciary.setIsOurChild(agent.getIsOurChild());

		fiduciary.setNotifyAllEvent(agent.getNotifyAllEvent());
		fiduciary.setNotifyOnEOL(agent.getNotifyOnEOL());
		fiduciary.setNotifyOnPassing(agent.getNotifyOnPassing());
		fiduciary.setNotifyOnSmallProcedures(agent.getNotifyOnSmallProcedures());

		fiduciary.setIsEmergencyContact(agent.getIsEmergencyContact());

		fiduciary.setHasSpecialNeeds(agent.getHasSpecialNeeds());
		fiduciary.setRequiresAssistance(agent.getRequiresAssistance());
		fiduciary.setBeneficiaryType(agent.getBeneficiaryType());
		ContactOrganization contactOrganization = agent.getContactOrganization();
		if (contactOrganization != null) {
			fiduciary.setContactName(contactOrganization.getContactName());
			fiduciary.setContactEmail(contactOrganization.getContactEmail());
			fiduciary.setContactPhoneNumber(contactOrganization.getContactPhoneNumber());
			fiduciary.setTaxPayerId(contactOrganization.getTaxPayerId());
			fiduciary.setOrganizationType(contactOrganization.getOrganizationType());
		}
		fiduciary.setCompanyName(agent.getCompanyName());
		
		return fiduciary;
	}
	
	private static void copyAddressDetails(Contact contact, FiduciaryDto fiduciaryDto) {
		LOGGER.info("==========coping address details============");
		if (contact.getCountry() != null) {
			
			fiduciaryDto.setCountryId(contact.getCountry().getCountryId());
			fiduciaryDto.setCountry(contact.getCountry().getName());
		}
		if (contact.getState() != null) {
			
			fiduciaryDto.setStateId(contact.getState().getId());
			fiduciaryDto.setState(contact.getState().getStateName());
		}
		fiduciaryDto.setCity(contact.getCity2());
		fiduciaryDto.setAddressLine1(contact.getAddressLine1());
		fiduciaryDto.setAddressLine2(contact.getAddressLine2());
		fiduciaryDto.setZipCode(contact.getZipCode());
		fiduciaryDto.setIsFiduciary(contact.getIsFiduciary());
	}
	
	public static FiduciaryDto setRelationText(FiduciaryDto fiduciary, Contact agent){
		if (agent.getRelation()!=RelationType.NA) {
			fiduciary.setRelation(agent.getRelation().getValue());
			fiduciary.setRelationText(RelationType.getRelation(agent.getRelation()));
		}else {
			fiduciary.setRelation(null);
			fiduciary.setRelationText(null);
		}
	  return fiduciary;
	}
}
