package com.lalit.mapper;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lalit.domain.Contact;
import com.lalit.dto.SpouseDto;


@Service
public class ContactMapperSecond {

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactMapperSecond.class);

	public void updateUserCustomaryFields(SpouseDto spouseDto, Contact spouse) {
		
		LOGGER.info("=========updateUserCustomaryFields========================");
		Boolean userEmergencyContact = !Objects.isNull(spouse.getIsEmergencyContact()) && spouse.getIsEmergencyContact()
				? spouseDto.getUserEmergencyContact() : null;
		spouse.setUserEmergencyContact(userEmergencyContact);

		Boolean userFiduciary = !Objects.isNull(spouse.getIsFiduciary()) && spouse.getIsFiduciary()
				? spouseDto.getUserFiduciary() : null;
		spouse.setUserFiduciary(userFiduciary);

		Boolean userBeneficiary = !Objects.isNull(spouse.getIsBeneficiary()) && spouse.getIsBeneficiary()
				? spouseDto.getUserBeneficiary() : null;
		spouse.setUserBeneficiary(userBeneficiary);
	}

}
