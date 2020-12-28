package com.lalit.domain;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class City extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private Long stateId;
	private String name;
	private boolean status;
}
