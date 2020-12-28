package com.lalit.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lalit.constants.LPOMiscConstants;

import lombok.Data;

@Data
public class UserProfileDto {

	
	private Long userId;

	@JsonIgnore
	private long firmId;

	
	private String firstName;

	
	private String middleName;

	
	private String lastName;

	private String preferredName;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	@NotBlank(message = "Please enter the email")
	private String email;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String secondaryEmail;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String tertiaryEmail;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	@NotBlank(message = "Please enter the phone number")
	private String mobileNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	private String secondaryMobileNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	private String tertiaryMobileNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	@NotBlank(message = "Please enter the phone number")
	private String landlineContactNumber;

	private String gender;

	private Boolean isUsCitizen;
	private String citizenShip;
	private boolean relationshipStatus;
	private String accountType;

	private String profilePic;
	private String maritalStatus;
	private boolean hasChildren;

	private Long addressId;
	
	private Long countryId;
	private String country;
	
	private Long stateId;
	private String state;
	
	private String city;
	
	private String zipCode;
	private String addressLine1;
	private String addressLine2;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date dob;

	private boolean isCurrentlyEmployed;
	private long employmentId;
	private String companyName;
	private String companyPhoneNumber;
	private String jobTitle;
	private String phoneNumber;
	private boolean isVeteran;
	private String dischageType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date joiningDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date dischargeDate;

	private String password;

}
