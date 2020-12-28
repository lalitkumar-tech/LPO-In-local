package com.lalit.enums;

import java.util.Arrays;
import java.util.List;


public enum OrganizationType {


	CORPORATION("Corporation"), PARTNERSHIP("Partnership"), LLC("LLC"), OTHER("Other"), IRREVOCABLE("Irrevocable"),
	REVOCABLE("Revocable");

	final String value;

	OrganizationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	// This enum is used for both charity and entity
	public static List<OrganizationType> entityTypeList = Arrays.asList(CORPORATION, PARTNERSHIP, LLC, OTHER);

	// This enum is used only for trust
	public static List<OrganizationType> trustTypeList = Arrays.asList(IRREVOCABLE, REVOCABLE);
}
