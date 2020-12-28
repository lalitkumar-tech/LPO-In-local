package com.lalit.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lalit.enums.AccountType;
import com.lalit.enums.AuthProvider;
import com.lalit.enums.Gender;
import com.lalit.enums.MaritalStatus;
import com.lalit.enums.PlaceOfDeath;


import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "userName") })
public class User extends BaseEntity{

	@Column(nullable = false)
	private String userName;

	private String firstName;


	private String middleName;


	private String lastName;


	private String preferedName;

	@Email
	@Column(nullable = false)
	private String email;

	@Email
	private String secondaryEmail;
	@Email
	private String tertiaryEmail;

	private String mobileNumber;
	private String secondaryMobileNumber;
	private String tertiaryMobileNumber;

	private String landlineContactNumber;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Address address;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	private boolean relationshipStatus;

	@Column(nullable = true)
	private boolean hasChildren;

	private Date dob;

	private boolean isActive;
	@Column(nullable = false)
	private boolean isUsCitizen;
	private String citizenShip;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private boolean isCurrentlyEmployed;

	private boolean isVeteran;

	@OneToOne(cascade = CascadeType.ALL)
	private EmployementDetail employmentDetail;

	private String imageUrl;

	@Column(nullable = false)
	private Boolean accountExpired;

	@Column(nullable = false)
	private Boolean accountNonLocked;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;
	
	@Column(nullable = false)
	private Boolean enabled;

	@JsonIgnore
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<StaffRole> staffRoles;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "firm_id")
	private Firm firm;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Document> documents = new HashSet<>();

	
	private int resendOtpCount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date disabledOn;

	private LocalDateTime dateOfDeath;
	@Enumerated(EnumType.STRING)
	private PlaceOfDeath placeOfDeath;

	@Column(columnDefinition = "tinyint(1) default 0")		//=======>ask
	private boolean onHold;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
