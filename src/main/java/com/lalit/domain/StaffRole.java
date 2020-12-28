package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;




@Entity
public class StaffRole extends BaseEntity{

	private static final long serialVersionUID = -8481403627413499832L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Firm firm;

	private String staffRole;

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	@Override
	public String toString() {
		return "StaffRole [firm=" + firm + ", staffRole=" + staffRole + "]";
	}
}
