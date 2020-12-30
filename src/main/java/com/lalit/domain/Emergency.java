package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lalit.enums.BloodType;


@Entity
public class Emergency extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -529298541967298283L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "contactId")
	private Long contactId;
	private int memberId;
	private String memberPIN;
	private String emergencyContactNumber;
	@Enumerated(EnumType.STRING)
	private BloodType bloodType;
	private String bloodTypeText;
	private String allergies;
	private String medication;
	private String medicalCondition;
	private String additionalInfo;
	private Boolean isOrganDonor;
	private String organ;
	private String donate;
	private Boolean hasPetsAtHome;
	private Boolean hasDependantdstHome;
	
	private String primaryPhysicianName;	
	private String primaryPhysicianPhone	;
	private String primaryPhysicianAddress	;
	private String primaryPhysicianEmail	;
	private String primaryPhysicianSpecialty;

	private String	specialistPhysicianName	 ;
	private String specialistPhysicianPhone	;
	private String specialistPhysicianAddress	;
	private String specialistPhysicianEmail	;
	private String specialistPhysicianSpecialty;
	
	
	
	
	public String getDonate() {
		return donate;
	}



	public void setDonate(String donate) {
		this.donate = donate;
	}



	public String getPrimaryPhysicianName() {
		return primaryPhysicianName;
	}



	public void setPrimaryPhysicianName(String primaryPhysicianName) {
		this.primaryPhysicianName = primaryPhysicianName;
	}



	public String getPrimaryPhysicianPhone() {
		return primaryPhysicianPhone;
	}



	public void setPrimaryPhysicianPhone(String primaryPhysicianPhone) {
		this.primaryPhysicianPhone = primaryPhysicianPhone;
	}



	public String getPrimaryPhysicianAddress() {
		return primaryPhysicianAddress;
	}



	public void setPrimaryPhysicianAddress(String primaryPhysicianAddress) {
		this.primaryPhysicianAddress = primaryPhysicianAddress;
	}



	public String getPrimaryPhysicianEmail() {
		return primaryPhysicianEmail;
	}



	public void setPrimaryPhysicianEmail(String primaryPhysicianEmail) {
		this.primaryPhysicianEmail = primaryPhysicianEmail;
	}



	public String getPrimaryPhysicianSpecialty() {
		return primaryPhysicianSpecialty;
	}



	public void setPrimaryPhysicianSpecialty(String primaryPhysicianSpecialty) {
		this.primaryPhysicianSpecialty = primaryPhysicianSpecialty;
	}



	public String getSpecialistPhysicianName() {
		return specialistPhysicianName;
	}



	public void setSpecialistPhysicianName(String specialistPhysicianName) {
		this.specialistPhysicianName = specialistPhysicianName;
	}



	public String getSpecialistPhysicianPhone() {
		return specialistPhysicianPhone;
	}



	public void setSpecialistPhysicianPhone(String specialistPhysicianPhone) {
		this.specialistPhysicianPhone = specialistPhysicianPhone;
	}



	public String getSpecialistPhysicianAddress() {
		return specialistPhysicianAddress;
	}



	public void setSpecialistPhysicianAddress(String specialistPhysicianAddress) {
		this.specialistPhysicianAddress = specialistPhysicianAddress;
	}



	public String getSpecialistPhysicianEmail() {
		return specialistPhysicianEmail;
	}



	public void setSpecialistPhysicianEmail(String specialistPhysicianEmail) {
		this.specialistPhysicianEmail = specialistPhysicianEmail;
	}



	public String getSpecialistPhysicianSpecialty() {
		return specialistPhysicianSpecialty;
	}



	public void setSpecialistPhysicianSpecialty(String specialistPhysicianSpecialty) {
		this.specialistPhysicianSpecialty = specialistPhysicianSpecialty;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Emergency() {
	}
	
	
	
	public int getMemberId() {
		return memberId;
	}



	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}



	public String getMemberPIN() {
		return memberPIN;
	}



	public void setMemberPIN(String memberPIN) {
		this.memberPIN = memberPIN;
	}



	public String getOrgan() {
		return organ;
	}


	public void setOrgan(String organ) {
		this.organ = organ;
	}


	public String getBloodTypeText() {
		return bloodTypeText;
	}

	public void setBloodTypeText(String bloodTypeText) {
		this.bloodTypeText = bloodTypeText;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public Boolean getIsOrganDonor() {
		return isOrganDonor;
	}
	public void setIsOrganDonor(Boolean isOrganDonor) {
		this.isOrganDonor = isOrganDonor;
	}
	public Boolean getHasPetsAtHome() {
		return hasPetsAtHome;
	}
	public void setHasPetsAtHome(Boolean hasPetsAtHome) {
		this.hasPetsAtHome = hasPetsAtHome;
	}
	public Boolean getHasDependantdstHome() {
		return hasDependantdstHome;
	}
	public void setHasDependantdstHome(Boolean hasDependantdstHome) {
		this.hasDependantdstHome = hasDependantdstHome;
	}

	@Override
	public String toString() {
		return "Emergency [user=" + user + ", emergencyContactNumber=" + emergencyContactNumber + ", bloodType="
				+ bloodType + ", allergies=" + allergies + ", medication=" + medication + ", medicalCondition="
				+ medicalCondition + ", additionalInfo=" + additionalInfo + ", isOrganDonor=" + isOrganDonor
				+ ", hasPetsAtHome=" + hasPetsAtHome + ", hasDependantdstHome=" + hasDependantdstHome + "]";
	}

}
