package com.lalit.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lalit.enums.DischageType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EmployementDetail extends BaseEntity{
	
	

	private static final long serialVersionUID = 1L;
	
	private String companyName;
	private String jobTitle;
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private DischageType dischageType;

	private Date joiningDate;
	private Date dischareDate;
	
	public EmployementDetail(String companyName, String jobTitle, String phoneNumber) {
		super();
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
