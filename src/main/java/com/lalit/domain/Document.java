package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lalit.enums.DocumentType;

import lombok.Data;


@Entity
@Data
public class Document extends BaseEntity {

	private static final long serialVersionUID = 1939791135590637486L;

	private String originalFileName;
	private String savedFileName;
	private String documentUrl;
	@Enumerated(EnumType.STRING)
	private DocumentType documentType;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Contact contact;

	
}
