package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lalit.enums.EmergencyContactFor;
import com.lalit.enums.RelationType;

@Entity
public class EmergencyContact extends BaseEntity {

	private static final long serialVersionUID = -2488884314028828940L;

	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@ManyToOne
	private Contact contact;
	@JsonIgnore
	@ManyToOne
	private Contact emergencyContact;
	@JsonIgnore
	@ManyToOne
	private User emergencyUser;
	@Enumerated(EnumType.STRING)
	private EmergencyContactFor emergencyContactFor;
	@Enumerated(EnumType.STRING)
	private RelationType relation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(Contact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public User getEmergencyUser() {
		return emergencyUser;
	}

	public void setEmergencyUser(User emergencyUser) {
		this.emergencyUser = emergencyUser;
	}

	public EmergencyContactFor getEmergencyContactFor() {
		return emergencyContactFor;
	}

	public void setEmergencyContactFor(EmergencyContactFor emergencyContactFor) {
		this.emergencyContactFor = emergencyContactFor;
	}

	public RelationType getRelation() {
		return relation;
	}

	public void setRelation(RelationType relation) {
		this.relation = relation;
	}
}
