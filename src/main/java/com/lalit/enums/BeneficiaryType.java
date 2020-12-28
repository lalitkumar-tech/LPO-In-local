package com.lalit.enums;

public enum BeneficiaryType {

	INDIVIDUAL("Individual"), ENTITY("Entity"), TRUST("Trust"), CHARITY("Charity");

	final String value;

	BeneficiaryType(String value) {
		this.value = value;
	}
}
