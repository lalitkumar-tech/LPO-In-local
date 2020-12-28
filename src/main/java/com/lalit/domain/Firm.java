package com.lalit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lalit.constants.LPOMiscConstants;
import com.lalit.enums.FirmType;



@Entity
//@Data
public class Firm extends BaseEntity{


	private static final long serialVersionUID = 3099250266468174878L;

	private String name;
	
	private String faxNumber;

	@Pattern(regexp = LPOMiscConstants.EMAIL_REGEX, message = "Please enter a valid email address")
	@NotBlank(message = "Please enter the email")
	private String email;

	@Pattern(regexp = LPOMiscConstants.PHONE_NUMBER_REGEX, message = "Please enter a valid phone number")
	@NotBlank(message = "Please enter the phone number")
	private String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private User firmAdmin;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private FirmAddress firmAddress;

	@Enumerated(EnumType.STRING)
	private FirmType firmType;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getFirmAdmin() {
		return firmAdmin;
	}

	public void setFirmAdmin(User firmAdmin) {
		this.firmAdmin = firmAdmin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public FirmType getFirmType() {
		return firmType;
	}

	public void setFirmType(FirmType firmType) {
		this.firmType = firmType;
	}

	
	public FirmAddress getFirmAddress() {
		return firmAddress;
	}

	public void setFirmAddress(FirmAddress firmAddress) {
		this.firmAddress = firmAddress;
	}

	public Firm() {
	}

	public Firm(String name, String faxNumber,
			@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[$&+,:;=?@#|'<>-^*()%!]]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid email address") @NotBlank(message = "Please enter the email") String email,
			@Pattern(regexp = "(^[0-9]{3}-[0-9]{3}-[0-9]{4}$)", message = "Please enter a valid phone number") @NotBlank(message = "Please enter the phone number") String phoneNumber,
			User firmAdmin, FirmType firmType) {
		super();
		this.name = name;
		this.faxNumber = faxNumber;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.firmAdmin = firmAdmin;
		this.firmType = firmType;
	}

	@Override
	public String toString() {
		return "Firm [name=" + name + ", faxNumber=" + faxNumber + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", firmAddress=" + firmAddress + ", firmType=" + firmType + "]";
	}


	
}
