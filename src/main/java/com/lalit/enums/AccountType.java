package com.lalit.enums;

public enum AccountType {

	JOINT("JOINT"), SEPERATE("SEPERATE"), LINKED("LINKED"), NA("NA");

	final String value;

	AccountType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static AccountType getByName(String genderValue) {
		for (AccountType type : values()) {
			if (type.getValue().equalsIgnoreCase(genderValue)) {
				return type;
			}
		}
		return null;
	}

}
