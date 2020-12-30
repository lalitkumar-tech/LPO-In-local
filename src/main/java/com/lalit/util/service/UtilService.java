package com.lalit.util.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lalit.constants.LPOMiscConstants;

public class UtilService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(LPOMiscConstants.EMAIL_REGEX,
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
