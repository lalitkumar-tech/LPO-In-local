package com.lalit.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.lalit.constants.LPOMiscConstants;
import com.lalit.enums.DocumentType;


public class SpouseDto {

	private Long id;

	private Long spouseId;

	private String fullName;
	@NotBlank(message = "Please enter the first name")
	private String firstName;
	private String middleName;
	@NotBlank(message = "Please enter the last name")
	private String lastName;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	@NotBlank(message = "Please enter the email")
	private String email;
	
	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String secondaryEmail;
	
	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String tertiaryEmail;
	
	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid Phone  number")
	@NotBlank(message = "Please enter the phone number")
	private String phoneNumber;
	
	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid Mobile number")
	@NotBlank(message = "Please enter the phone number")
	private String mobileNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	private String secondaryMobileNumber;
	
	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	private String tertiaryMobileNumber;

	private String spouseGender;
	
	private String accountType;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	@NotBlank(message = "Please enter the phone number")
	private String emergencyContactNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	private String landLineContactNumber;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private String dob;

	private String legalStatus;
	private String preferredName;
//	private Boolean preNuptialAgreement;
//	private Boolean postNuptialAgreement;
	private Boolean livingWithSpouse;

////	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
//	private String preNuptialDate;
////	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
//	private String postNuptialDate;

	private String relation;
	private String country;
	private Long countryId;
	private String state;
	private Long stateId;
	private String city;
	private Long cityId;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;

	private Boolean isBeneficiary;	
	private Boolean isFiduciary;

	private Boolean isUsCitizen;
	private String citizenShip;
	private Boolean isEmergencyContact;


	private DocumentType documentType;

	private Boolean userFiduciary;
	private Boolean userBeneficiary;
	private Boolean userEmergencyContact;

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
	
	public Boolean getIsEmergencyContact() {
		return isEmergencyContact;
	}

	public void setIsEmergencyContact(Boolean isEmergencyContact) {
		this.isEmergencyContact = isEmergencyContact;
	}

	public String getCitizenShip() {
		return citizenShip;
	}

	public void setCitizenShip(String citizenShip) {
		this.citizenShip = citizenShip;
	}

	public void setIsUsCitizen(Boolean isUsCitizen) {
		this.isUsCitizen = isUsCitizen;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Boolean getIsUsCitizen() {
		return isUsCitizen;
	}

	public void setUsCitizen(Boolean isUsCitizen) {
		this.isUsCitizen = isUsCitizen;
	}

	public Boolean getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsFiduciary() {
		return isFiduciary;
	}

	public void setIsFiduciary(Boolean isFiduciary) {
		this.isFiduciary = isFiduciary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(Long spouseId) {
		this.spouseId = spouseId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpouseGender() {
		return spouseGender;
	}

	public void setSpouseGender(String spouseGender) {
		this.spouseGender = spouseGender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}



	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLandLineContactNumber() {
		return landLineContactNumber;
	}

	public void setLandLineContactNumber(String landLineContactNumber) {
		this.landLineContactNumber = landLineContactNumber;
	}

	public Boolean getLivingWithSpouse() {
		return livingWithSpouse;
	}

	public void setLivingWithSpouse(Boolean livingWithSpouse) {
		this.livingWithSpouse = livingWithSpouse;
	}

	public String getTertiaryMobileNumber() {
		return tertiaryMobileNumber;
	}

	public void setTertiaryMobileNumber(String tertiaryMobileNumber) {
		this.tertiaryMobileNumber = tertiaryMobileNumber;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getTertiaryEmail() {
		return tertiaryEmail;
	}

	public void setTertiaryEmail(String tertiaryEmail) {
		this.tertiaryEmail = tertiaryEmail;
	}

	public String getSecondaryMobileNumber() {
		return secondaryMobileNumber;
	}

	public void setSecondaryMobileNumber(String secondaryMobileNumber) {
		this.secondaryMobileNumber = secondaryMobileNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Boolean getUserFiduciary() {
		return userFiduciary;
	}

	public void setUserFiduciary(Boolean userFiduciary) {
		this.userFiduciary = userFiduciary;
	}

	public Boolean getUserBeneficiary() {
		return userBeneficiary;
	}

	public void setUserBeneficiary(Boolean userBeneficiary) {
		this.userBeneficiary = userBeneficiary;
	}

	public Boolean getUserEmergencyContact() {
		return userEmergencyContact;
	}

	public void setUserEmergencyContact(Boolean userEmergencyContact) {
		this.userEmergencyContact = userEmergencyContact;
	}

	@Override
	public String toString() {
		return "SpouseDto [id=" + id + ", spouseId=" + spouseId + ", accountType=" +  accountType + ", fullName=" + fullName + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", secondaryEmail="
				+ secondaryEmail + ", tertiaryEmail=" + tertiaryEmail + ", phoneNumber=" + phoneNumber
				+ ", mobileNumber=" + mobileNumber + ", secondaryMobileNumber=" + secondaryMobileNumber
				+ ", tertiaryMobileNumber=" + tertiaryMobileNumber + ", spouseGender=" + spouseGender
				+ ", emergencyContactNumber=" + emergencyContactNumber + ", landLineContactNumber="
				+ landLineContactNumber + ", dob=" + dob + ", legalStatus=" + legalStatus + ", preferredName="
//				+ preferredName + ", preNuptialAgreement=" + preNuptialAgreement + ", postNuptialAgreement="
//				+ postNuptialAgreement
				+ ", livingWithSpouse=" + livingWithSpouse + //", preNuptialDate=" + preNuptialDate
//				+ ", postNuptialDate=" + postNuptialDate +
				", relation=" + relation + ", country=" + country
				+ ", countryId=" + countryId + ", state=" + state + ", stateId=" + stateId + ", city=" + city
				+ ", cityId=" + cityId + ", zipCode=" + zipCode + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", isBeneficiary=" + isBeneficiary + ", isFiduciary=" + isFiduciary + ", isUsCitizen="
				+ isUsCitizen + "]";
	}

}
