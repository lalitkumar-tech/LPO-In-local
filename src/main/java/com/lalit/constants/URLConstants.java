package com.lalit.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class URLConstants {
	
	public static final String USERID ="/{userId}";
	public static final String CONTACTID ="/{contactId}";
	
	public static final String USER_PROFILE ="/user_profile";
	public static final String USER_LIMITED_DATA ="/user_limited_data"+USERID;
	public static final String GET_USER_PROFILE ="/user_profile"+USERID;
	
	public static final String CONTACT ="/contact";
	public static final String DELETE_CONTACT =CONTACT+"/delete"+USERID+CONTACTID;
	
	public static final String SPOUSE =CONTACT+"/spouse"+USERID;
	public static final String CHILD =CONTACT+"/child"+USERID;
	

	public static final String BASE_UTIL ="/util";
	public static final String COUNTRIES = BASE_UTIL + "/countries";
	public static final String STATES = COUNTRIES + "/{countryId}/states";

}
