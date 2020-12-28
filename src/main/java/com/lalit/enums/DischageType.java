package com.lalit.enums;


public enum DischageType {

	HONORABLE("HONORABLE"), GENERAL("GENERAL"), OTHER_THAN_HONORABLE("OTHER_THAN_HONORABLE"),
	BAD_CONDUCT("BAD_CONDUCT"), DISHONORABLE("DISHONORABLE"), OFFICER_DISCHARGE("OFFICER_DISCHARGE"),
	ENTRY_LEVEL_SEPARATION("ENTRY_LEVEL_SEPARATION");

	private final String value;

	DischageType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static DischageType getByName(String discharfeTypeValue) {
		for (DischageType prop : values()) {
			if (prop.getValue().equalsIgnoreCase(discharfeTypeValue)) {
				return prop;
			}
		}
		return null;
	}

}
