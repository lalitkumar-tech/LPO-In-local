package com.lalit.enums;



public enum BloodType {
	O_POSITIVE("O_POSITIVE"),O_NEGATIVE("O_NEGATIVE"), 
	A_POSITIVE("A_POSITIVE"),A_NEGATIVE("A_NEGATIVE"),
	B_POSITIVE("B_POSITIVE"),B_NEGATIVE("B_NEGATIVE"),
	AB_POSITIVE("AB_POSITIVE"), AB_NEGATIVE("AB_NEGATIVE");

	final String value;

	BloodType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static BloodType getByName(String genderValue) {
		for (BloodType gender : values()) {
			if (gender.getValue().equalsIgnoreCase(genderValue)) {
				return gender;
			}
		}
		return null;
//		throw new IllegalArgumentException(genderValue + " is not a valid Gender.");
	}
}