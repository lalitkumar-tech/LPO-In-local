package com.lalit.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.lalit.constants.LPOMiscConstants;
import com.lalit.enums.BeneficiaryType;
import com.lalit.enums.OrganizationType;

import lombok.Data;

@Data
public class FiduciaryDto {

	private Long id;

	private Long userId;

	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nickName;
	
	private String gender;
	
	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	@NotBlank(message = "Please enter the email")
	private String email;
	
	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String secondaryEmail;
	
	
	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String tertiaryEmail;

	
	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	@NotBlank(message = "Please enter the phone number")
	private String phoneNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")

	private String secondaryMobileNumber;
	
	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")

	private String tertiaryMobileNumber;

	private String dob;


	private String contactType;

	private String contactGroup;
	private String relation;
	private String relationText;
	
	private String country;
	private Long countryId;
	private String state;
	private Long stateId;
	private String city;
	private Long cityId;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;
	
	private Boolean notifyOnPassing;
	private Boolean notifyOnEOL;
	private Boolean notifyAllEvent;
	private Boolean notifyOnSmallProcedures;
	private Boolean sendGreeting;
	private Boolean isEmergencyContact;
	
	private Boolean isBeneficiary;
	private Boolean isFiduciary;

	private Boolean isOurChild; 
	private Boolean isHisChild; 
	private Boolean isHerChild; 
	private Boolean isDeceased;
	private Boolean hasSpecialNeeds;
	private Boolean requiresAssistance; 
	private String occupation;	 
	
	private Boolean isUsCitizen;
	private String citizenShip;
	
	private String contactName;
	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String contactEmail;
	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	private String contactPhoneNumber;
	private String taxPayerId;
	private OrganizationType organizationType;
	private BeneficiaryType beneficiaryType;
	private String companyName;
	
}
