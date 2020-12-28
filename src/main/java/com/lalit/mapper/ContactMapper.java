package com.lalit.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lalit.domain.Contact;
import com.lalit.dto.ChildDto;
import com.lalit.dto.SpouseDto;
import com.lalit.repository.CountryRepository;
import com.lalit.utils.GeneralUtils;




@Component
public class ContactMapper {
	
	@Autowired
	 CountryRepository countryRepository;

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactMapper.class);
	
	public static SpouseDto toSpouseDto(Contact contact) {
		SpouseDto spouseDto = new SpouseDto();
		spouseDto.setId(contact.getId());
		spouseDto.setSpouseId(contact.getUser().getId());
		spouseDto.setAccountType(contact.getAccountType());

		spouseDto.setFullName(contact.getFullName());
		spouseDto.setFirstName(contact.getFirstName());
		spouseDto.setMiddleName(contact.getMiddleName());
		spouseDto.setLastName(contact.getLastName());
		spouseDto.setPreferredName(contact.getPreferredName());

		spouseDto.setEmail(contact.getEmail());
		spouseDto.setSecondaryEmail(contact.getSecondaryEmail());
		spouseDto.setTertiaryEmail(contact.getTertiaryEmail());

		spouseDto.setPhoneNumber(contact.getPhoneNumber());
		spouseDto.setSecondaryMobileNumber(contact.getSecondaryMobileNumber());
		spouseDto.setTertiaryMobileNumber(contact.getTertiaryMobileNumber());
		spouseDto.setLandLineContactNumber(contact.getLandLineContactNumber());

		boolean isChild = false;
		copyOtherValuesTodto(spouseDto, contact);
		copyAddressDetails(contact,spouseDto);
		return spouseDto;
	}

	/*private static void copyAddressDetails(SpouseDto spouseDto, Contact spouse) {
		if (spouse.getCountry() != null) {
			spouseDto.setCountryId(spouse.getCountry().getCountryId());
			spouseDto.setCountry(spouse.getCountry().getName());
		}
		if (spouse.getState() != null) {
			spouseDto.setStateId(spouse.getState().getId());
			spouseDto.setState(spouse.getState().getStateName());
		}
		spouseDto.setCity(spouse.getCity2());
		spouseDto.setAddressLine1(spouse.getAddressLine1());
		spouseDto.setAddressLine2(spouse.getAddressLine2());
		spouseDto.setZipCode(spouse.getZipCode());
	}
*/
	private static void copyOtherValuesTodto(SpouseDto spouseDto, Contact contact) {
		spouseDto.setLivingWithSpouse(contact.getLivingWithSpouse());
		spouseDto.setEmergencyContactNumber(contact.getEmergencyContactNumber());
		spouseDto.setDob(Objects.isNull(contact.getDob())?null:GeneralUtils.getDateInFormat(contact.getDob()));
		spouseDto.setSpouseGender(contact.getGender().getValue());
		spouseDto.setRelation(contact.getRelation().getValue());  
		LOGGER.info("================check relation value==========="+contact.getRelation().getValue());
		spouseDto.setUsCitizen(contact.getIsUsCitizen());
		spouseDto.setCitizenShip(contact.getCitizenShip());
		spouseDto.setIsFiduciary(contact.getIsFiduciary());
		spouseDto.setIsBeneficiary(contact.getIsBeneficiary());
		spouseDto.setIsEmergencyContact(contact.getIsEmergencyContact());
		spouseDto.setUserBeneficiary(contact.getUserBeneficiary());
		spouseDto.setUserFiduciary(contact.getUserFiduciary());
		spouseDto.setUserEmergencyContact(contact.getUserEmergencyContact());
	}
	
	public static ChildDto toChildDto(Contact contact){
		ChildDto childDto = new ChildDto();
		childDto.setId(contact.getId());
		childDto.setParentId(contact.getUser().getId());
		childDto.setFullName(contact.getFullName());

		childDto.setFirstName(contact.getFirstName());
		childDto.setMiddleName(contact.getMiddleName());
		childDto.setLastName(contact.getLastName());

		childDto.setNickName(contact.getNickName());
		childDto.setEmail(contact.getEmail());
		childDto.setSecondaryEmail(contact.getSecondaryEmail());
		childDto.setTertiaryEmail(contact.getTertiaryEmail());

		childDto.setPhoneNumber(contact.getPhoneNumber());
		childDto.setLandlineContactNumber(contact.getLandLineContactNumber());
		childDto.setSecondaryMobileNumber(contact.getSecondaryMobileNumber());
		childDto.setTertiaryMobileNumber(contact.getTertiaryMobileNumber());
		childDto.setEmergencyContactNumber(contact.getEmergencyContactNumber());
		childDto.setDob(Objects.isNull(contact.getDob()) ? null : GeneralUtils.getDateInFormat(contact.getDob()));
		childDto.setCitizenShip(contact.getCitizenShip());
		childDto.setIsUsCitizen(contact.getIsUsCitizen());
		
		if (contact.getGender() != null) {
			childDto.setChildGender(contact.getGender().getValue());

		}
		
		LocalDate birthday = contact.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LOGGER.info("=================child birthday = "+birthday+"========");
		Period period = Period.between(birthday, LocalDate.now());
		LOGGER.info("=================period(age of child in year) ="+period+"===========");
		LOGGER.info("=================period(age of child in year) ="+period.getYears()+"===========");
		if(period.getYears()>18){
			childDto.setMinor(false);
		}else{
			childDto.setMinor(true);
			childDto.setGuardianName(contact.getGuardianName());
			childDto.setGuardianEmail(contact.getGuardianEmail());
			childDto.setGuardianPhoneNumber(contact.getGuardianPhoneNumber());
		}
		childDto.setStaysWith(contact.getStaysWith() == null ? null : contact.getStaysWith().getValue());

		childDto.setIsFiduciary(contact.getIsFiduciary());
		childDto.setIsBeneficiary(contact.getIsBeneficiary());
		childDto.setIsHerChild(contact.getIsHerChild());
		childDto.setIsHisChild(contact.getIsHisChild());
		childDto.setIsOurChild(contact.getIsOurChild());
		childDto.setIsDeceased(contact.getIsDeceased());
		childDto.setHasSpecialNeeds(contact.getHasSpecialNeeds());
		childDto.setRequiresAssistance(contact.getRequiresAssistance());
		childDto.setOccupation(contact.getOccupation());
		childDto.setIsEmergencyContact(contact.getIsEmergencyContact());
		
		childDto.setRelation(contact.getRelation().getValue());
		LOGGER.info("==========relation value dto============"+contact.getRelation().getValue());
		childDto.setRelationText(contact.getRelation().getText());
		LOGGER.info("==========relation text dto============"+contact.getRelation().getText());
		
		copyAddressDetails(contact,childDto);
		return childDto;
	}


	private static void copyAddressDetails(Contact contact, SpouseDto spouseDto) {
		if (contact.getCountry() != null) {
			spouseDto.setCountryId(contact.getCountry().getCountryId());
			spouseDto.setCountry(contact.getCountry().getName());
		}
		if (contact.getState() != null) {
			spouseDto.setStateId(contact.getState().getId());
			spouseDto.setState(contact.getState().getStateName());
		}

		spouseDto.setCity(contact.getCity2());
		spouseDto.setAddressLine1(contact.getAddressLine1());
		spouseDto.setAddressLine2(contact.getAddressLine2());
		spouseDto.setZipCode(contact.getZipCode());
	}
	

	private static void copyAddressDetails(Contact contact, ChildDto childDto) {
		if (contact.getCountry() != null) {
			childDto.setCountryId(contact.getCountry().getCountryId());
			childDto.setCountry(contact.getCountry().getName());
		}
		if (contact.getState() != null) {
			childDto.setStateId(contact.getState().getId());
			childDto.setState(contact.getState().getStateName());

		}
		childDto.setCity(contact.getCity2());
		childDto.setAddressLine1(contact.getAddressLine1());
		childDto.setAddressLine2(contact.getAddressLine2());
		childDto.setZipCode(contact.getZipCode());
	}

}
