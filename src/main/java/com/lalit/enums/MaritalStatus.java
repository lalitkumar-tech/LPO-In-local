package com.lalit.enums;


public enum MaritalStatus {


	NA("NA"),SINGLE("SINGLE"), MARRIED("MARRIED"), DIVORCEE("DIVORCEE"), WIDOW("WIDOW"),WIDOWER("WIDOWER");// ,DIVORCEE("Divorcee"),WIDOWER("Widower");

	String value;

	MaritalStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	void setValue(String value) {
		this.value = value;
	}

	public static MaritalStatus getByName(String mStatusValue) {
		for (MaritalStatus mStatus : values()) {
			if (mStatus.getValue().equalsIgnoreCase(mStatusValue)) {
				return mStatus;
			}
		}
		return null;

	}
}
