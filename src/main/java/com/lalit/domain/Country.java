package com.lalit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable{

	/*
	 * lalit
	 * 
	 * */
	private static final long serialVersionUID = -5242647369420467364L;
	@Id
	private Long countryId;
	
	private String name;
	private String isoCode2;
	private String isoCode3;
	private Integer status;
	private String phoneCode;
	private String timeZone;
	
}
