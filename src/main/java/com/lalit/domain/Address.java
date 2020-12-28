package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity
@Data
public class Address extends BaseEntity{
	
	
	private static final long serialVersionUID = -889403199099498986L;
	

	@OneToOne
	private Country country;

	@OneToOne
	private State state;

	private String city;

	private String zipCode;

	private String address_one;

	private String address_two;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
