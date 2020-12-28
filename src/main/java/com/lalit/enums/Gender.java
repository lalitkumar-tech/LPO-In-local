package com.lalit.enums;


public enum Gender {

	MALE("Male"), FEMALE("Female");

	final String value;

	Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Gender getByName(String genderValue) {
		for (Gender gender : values()) {
			if (gender.getValue().equalsIgnoreCase(genderValue)) {
				return gender;
			}
		}
		return null;
	}

}
