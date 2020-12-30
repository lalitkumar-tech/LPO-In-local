package com.lalit.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lalit.constants.LPOMiscConstants;
import com.lalit.enums.BeneficiaryType;
import com.lalit.enums.Gender;
import com.lalit.enums.RelationType;
import com.lalit.enums.StaysWith;

import lombok.Data;

@Entity
@Data
public class Contact extends BaseEntity{

	private static final long serialVersionUID = 4038972239945143467L;

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	private String contactType;
	private String contactGroup;

	@Enumerated(EnumType.STRING)
	private RelationType relation;

	private String fullName;

	private String accountType;
	private String firstName;
	private String middleName;
	private String lastName;

	private Boolean isUsCitizen;

	private String citizenShip;

	private String email;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String secondaryEmail;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	private String tertiaryEmail;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")

	private String secondaryMobileNumber;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")

	private String tertiaryMobileNumber;

	private String phoneNumber;
	private String emergencyContactNumber;
	private String landLineContactNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String legalStatus;
	private String preferredName;
	private Boolean preNuptialAgreement;
	private Boolean postNuptialAgreement;
	@Column(nullable = true)
	private Date preNuptialDate;
	@Column(nullable = true)
	private Date postNuptialDate;
	@Column(nullable = true)
	private Boolean livingWithSpouse;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_country_id")
	private Country country;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id")
	private State state;
	
	private String city2;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;

	private String nickName;

	private Boolean minor;

	private String guardianPhoneNumber;
	private String guardianEmail;
	private String guardianName;

	private Boolean isBeneficiary;
	private Boolean isFiduciary;

	private String occupation;
	private Boolean isHisChild;
	private Boolean isHerChild;
	private Boolean isOurChild;
	private Boolean isDeceased;
	private Boolean hasSpecialNeeds;
	private Boolean requiresAssistance;

	private Boolean notifyOnPassing;
	private Boolean notifyOnEOL;
	private Boolean notifyOnSmallProcedures;
	private Boolean notifyAllEvent;
	private Boolean sendGreeting;
	private Boolean isEmergencyContact;

	@Enumerated(EnumType.STRING)
	private StaysWith staysWith;
	
	@Enumerated(EnumType.STRING)
	private BeneficiaryType beneficiaryType;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_organization_id")
	private ContactOrganization contactOrganization;

	/**
	 * userFiduciary means user(client) is fiduciary for contact or not.
	 * Same for userBeneficiary and userEmergencyContact.
	 * These 3 fields used only for spouse.
	 */
	private Boolean userFiduciary;
	private Boolean userBeneficiary;
	private Boolean userEmergencyContact;

	private String companyName;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFullName() {
		String fullName = StringUtils.isEmpty(this.firstName)  ?  "" : StringUtils.capitalize(this.firstName);
		if(!StringUtils.isEmpty(this.middleName)) {
			fullName += " " + StringUtils.capitalize(this.middleName);
		}
		if(!StringUtils.isEmpty(this.lastName)) { 
			
			fullName += " " + StringUtils.capitalize(this.lastName);
		}
		return fullName;
	}

	

}
