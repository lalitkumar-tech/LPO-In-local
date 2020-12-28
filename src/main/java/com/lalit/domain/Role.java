package com.lalit.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data

public class Role extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String role;
	private String description;
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;
	
}
