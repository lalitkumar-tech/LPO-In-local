package com.lalit.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.Getter;


@Getter
public enum RelationType {

	NA("NA", "NA"), SON("SON", "Son"), DAUGHTER("DAUGHTER", "Daughter"),
	STEP_SON("STEP_SON","Step-Son"),
	STEP_DAUGHTER("STEP_DAUGHTER", "Step Daughter"), WIFE("WIFE", "Wife"),
	HUSBAND("HUSBAND", "Husband"), PEER("PEER", "Peer"), FATHER("FATHER", "Father"),
	MOTHER("MOTHER", "Mother"),
	BROTHER("BROTHER", "Brother"), SISTER("SISTER", "Sister"),
	STEP_FATHER("STEP_FATHER", "Step-Father"), STEP_MOTHER("STEP_MOTHER", "Step-Mother"),
	STEP_BROTHER("STEP_BROTHER", "Step-Brother"), STEP_SISTER("STEP_SISTER", "Step-Sister"),
	FATHER_IN_LAW("FATHER_IN_LAW", "Father-in-Law"), MOTHER_IN_LAW("MOTHER_IN_LAW", "Mother-in-Law"),
	BROTHER_IN_LAW("BROTHER_IN_LAW", "Brother-in-Law"),
	SISTER_IN_LAW("SISTER_IN_LAW", "Sister-In-Law"), SON_IN_LAW("SON_IN_LAW", "Son-In-Law"),
	DAUGHTER_IN_LAW("DAUGHTER_IN_LAW", "Daughter-in-Law"), ATTORNEY("ATTORNEY", "Attorney"),
	PARALEGAL("PARALEGAL", "Paralegal"), LEGAL_ASSISTANT("LEGAL_ASSISTANT","Legal Assistant"),
	DOCTOR("DOCTOR", "Doctor"), DENTIST("DENTIST", "Dentist"), NURSE("NURSE", "Nurse"),
	GERIATRIC_CARE_MANAGER("GERIATRIC_CARE_MANAGER", "Geriatric Care Manager"), ACCOUNTANT("ACCOUNTANT", "Accountant"),
	FINANCIAL_PLANNER("FINANCIAL_PLANNER", "Financial Planner"),
	BANKER("BANKER", "Banker"), REAL_ESTATE_AGENT("REAL_ESTATE_AGENT", "Real Estate Agent"),
	PROPERTY_MANAGER("PROPERTY_MANAGER", "Property Manager"),
	CO_WORKER("CO_WORKER", "Co-Worker"), BILL_PAYER("BILL_PAYER", "Bill-Payer"),
	OTHER("OTHER", "Other"), PERSONAL_CONTACT("PERSONAL_CONTACT", "Personal Contact");

	final String value;
	final String text;

	RelationType(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public static RelationType getByName(String relationValue) {
		for (RelationType relation : values()) {
			if (relation.getValue().equalsIgnoreCase(relationValue)) {
				return relation;
			}
		}
		return NA;
	}

	public static RelationType of(String type) {
		try {
			return RelationType.valueOf(type);
		} catch (Exception e) {
			return null;
		}
	}

	public static List<RelationType> emergencyList = Arrays.asList(SON, DAUGHTER, STEP_SON, STEP_DAUGHTER, WIFE,
			HUSBAND);

	public static List<RelationType> importantList = Arrays.asList(ATTORNEY, PARALEGAL, LEGAL_ASSISTANT,
			GERIATRIC_CARE_MANAGER, ACCOUNTANT, FINANCIAL_PLANNER, BANKER, REAL_ESTATE_AGENT, PROPERTY_MANAGER,
			BILL_PAYER, OTHER);

	public static boolean isAlreadyAgent(RelationType relation){
		return Arrays.asList(WIFE, HUSBAND).stream().anyMatch(relationType -> relationType.equals(relation));
	}
	public static String getRelation(RelationType relation) {
		if(Objects.isNull(relation)) return null;
		return relation.getText();
	}

	public static List<RelationType> children = Arrays.asList(RelationType.DAUGHTER, RelationType.SON,
			RelationType.STEP_DAUGHTER, RelationType.STEP_SON);
	public static String childrenList = children.stream().map(RelationType::getValue).collect(Collectors.joining(","));

	public static List<RelationType> spouseList = Arrays.asList(RelationType.WIFE, RelationType.HUSBAND);
}
