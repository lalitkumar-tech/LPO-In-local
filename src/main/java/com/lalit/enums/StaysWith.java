package com.lalit.enums;


public enum StaysWith {


	CLIENT("CLIENT"), SPOUSE("SPOUSE"), BOTH("BOTH"), NEITHER("NEITHER");

	final String value;

	StaysWith(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StaysWith getByName(String genderValue) {
		for (StaysWith gender : values()) {
			if (gender.getValue().equalsIgnoreCase(genderValue)) {
				return gender;
			}
		}
		return null;
	}
}
