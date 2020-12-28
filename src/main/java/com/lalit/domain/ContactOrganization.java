package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lalit.enums.OrganizationType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class ContactOrganization extends BaseEntity{

	private static final long serialVersionUID = 4196218268784202237L;
	
	
	private String contactName;
	private String contactEmail;
	private String contactPhoneNumber;
	private String taxPayerId;
	@Enumerated(EnumType.STRING)
	private OrganizationType organizationType;
	
}
