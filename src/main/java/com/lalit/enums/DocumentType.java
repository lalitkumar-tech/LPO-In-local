package com.lalit.enums;



public enum DocumentType {

	PROFILE_PIC("profile_pic"),
	HC_POA("hcpoa"),
	F_POA("fpoa"), LIVING_WILL("livingwill"), MISC("MISC");

	final String value;

	DocumentType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static DocumentType getByName(String value) {
		for (DocumentType type : values()) {
			if (type.getValue().equalsIgnoreCase(value)) {
				return type;
			}
		}
		return null;
	}
}
