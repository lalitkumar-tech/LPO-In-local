package com.lalit.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.lalit.constants.LPOMiscConstants;
import com.lalit.enums.DocumentType;


public class ChildDto {

	private Long id;

	private Long parentId;

	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
//	@NotBlank(message = "Please enter the email")
	private String email;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String secondaryEmail;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String tertiaryEmail;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
//	@NotBlank(message = "Please enter the phone number")
	private String phoneNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
//	@NotBlank(message = "Please enter the phone number")
	private String secondaryMobileNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
//	@NotBlank(message = "Please enter the phone number")
	private String tertiaryMobileNumber;

	private String childGender;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
//	@NotBlank(message = "Please enter the phone number")
	private String landlineContactNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
//	@NotBlank(message = "Please enter the phone number")
	private String emergencyContactNumber;

	@NotBlank(message = "Please provide a DOB for child.")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private String dob;

	private String nickName;
	private boolean minor;
	private String staysWith;
	private Boolean isUsCitizen;
	private String citizenShip;

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

	private String guardianPhoneNumber;
	private String guardianEmail;
	private String guardianName;

	private String relation;
	private String relationText;
	private Boolean isOurChild;
	private Boolean isHisChild;
	private Boolean isHerChild;
	private Boolean isDeceased;
	private Boolean hasSpecialNeeds;
	private Boolean requiresAssistance;
	private String occupation;
	private Boolean isEmergencyContact;

	private DocumentType documentType;

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getRelationText() {
		return relationText;
	}

	public void setRelationText(String relationText) {
		this.relationText = relationText;
	}

	public Boolean getIsEmergencyContact() {
		return isEmergencyContact;
	}

	public void setIsEmergencyContact(Boolean isEmergencyContact) {
		this.isEmergencyContact = isEmergencyContact;
	}

	public String getStaysWith() {
		return staysWith;
	}

	public void setStaysWith(String staysWith) {
		this.staysWith = staysWith;
	}

	public String getCitizenShip() {
		return citizenShip;
	}

	public void setCitizenShip(String citizenShip) {
		this.citizenShip = citizenShip;
	}

	public Boolean getIsDeceased() {
		return isDeceased;
	}

	public void setIsDeceased(Boolean isDeceased) {
		this.isDeceased = isDeceased;
	}

	public Boolean getHasSpecialNeeds() {
		return hasSpecialNeeds;
	}

	public void setHasSpecialNeeds(Boolean hasSpecialNeeds) {
		this.hasSpecialNeeds = hasSpecialNeeds;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Boolean getIsHisChild() {
		return isHisChild;
	}

	public void setIsHisChild(Boolean isHisChild) {
		this.isHisChild = isHisChild;
	}

	public Boolean getIsHerChild() {
		return isHerChild;
	}

	public void setIsHerChild(Boolean isHerChild) {
		this.isHerChild = isHerChild;
	}

	public Boolean getIsOurChild() {
		return isOurChild;
	}

	public void setIsOurChild(Boolean isOurChild) {
		this.isOurChild = isOurChild;
	}

	public Boolean getRequiresAssistance() {
		return requiresAssistance;
	}

	public void setRequiresAssistance(Boolean requiresAssistance) {
		this.requiresAssistance = requiresAssistance;
	}

	public String getGuardianPhoneNumber() {
		return guardianPhoneNumber;
	}

	public void setGuardianPhoneNumber(String guardianPhoneNumber) {
		this.guardianPhoneNumber = guardianPhoneNumber;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

//	public String getGuardianAddress() {
//		return guardianAddress;
//	}
//
//	public void setGuardianAddress(String guardianAddress) {
//		this.guardianAddress = guardianAddress;
//	}

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

	public String getRelation() {
		return relation;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullame) {
		this.fullName = fullame;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
//
//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}


	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isMinor() {
		return minor;
	}

	public void setMinor(boolean minor) {
		this.minor = minor;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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

	public String getChildGender() {
		return childGender;
	}

	public void setChildGender(String childGender) {
		this.childGender = childGender;
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

	public String getLandlineContactNumber() {
		return landlineContactNumber;
	}

	public void setLandlineContactNumber(String landlineContactNumber) {
		this.landlineContactNumber = landlineContactNumber;
	}

	public String getGuardianEmail() {
		return guardianEmail;
	}

	public void setGuardianEmail(String guardianEmail) {
		this.guardianEmail = guardianEmail;
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

	public String getTertiaryMobileNumber() {
		return tertiaryMobileNumber;
	}

	public void setTertiaryMobileNumber(String tertiaryMobileNumber) {
		this.tertiaryMobileNumber = tertiaryMobileNumber;
	}

	public Boolean getIsUsCitizen() {
		return isUsCitizen;
	}

	public void setIsUsCitizen(Boolean isUsCitizen) {
		this.isUsCitizen = isUsCitizen;
	}

	@Override
	public String toString() {
		return "ChildDto [id=" + id + ", parentId=" + parentId + ", fullName=" + fullName + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", secondaryEmail="
				+ secondaryEmail + ", tertiaryEmail=" + tertiaryEmail + ", phoneNumber=" + phoneNumber
				+ ", secondaryMobileNumber=" + secondaryMobileNumber + ", tertiaryMobileNumber=" + tertiaryMobileNumber
				+ ", childGender=" + childGender + ", landlineContactNumber=" + landlineContactNumber
				+ ", emergencyContactNumber=" + emergencyContactNumber + ", dob=" + dob + ", nickName=" + nickName
				+ ", minor=" + minor + ", isUsCitizen=" + isUsCitizen + ", country=" + country + ", countryId="
				+ countryId + ", state=" + state + ", stateId=" + stateId + ", city=" + city + ", cityId=" + cityId
				+ ", zipCode=" + zipCode + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", isBeneficiary=" + isBeneficiary + ", isFiduciary=" + isFiduciary + ", guardianPhoneNumber="
				+ guardianPhoneNumber + ", guardianEmail=" + guardianEmail + ", guardianName=" + guardianName
				+ ", relation=" + relation + ", isOurChild=" + isOurChild + ", isHisChild=" + isHisChild
				+ ", isHerChild=" + isHerChild + ", isDeceased=" + isDeceased + ", hasSpecialNeeds=" + hasSpecialNeeds
				+ ", requiresAssistance=" + requiresAssistance + ", occupation=" + occupation + "]";
	}
}
