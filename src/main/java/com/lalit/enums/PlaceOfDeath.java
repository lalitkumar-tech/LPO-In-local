package com.lalit.enums;

public enum PlaceOfDeath {

	 HOME("Home"), HOSPICE("Hospice"), CARE_COMMUNITY("Care Community");
    private String value;
    PlaceOfDeath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
