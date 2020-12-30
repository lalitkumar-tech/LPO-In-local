package com.lalit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class GeneralUtils {

	static final SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	
	public static String getDateInFormat(Date date) {
		return format.format(date);
	}
	
	public static final String PERSONAL = "Personal";
	public static final String FAMILY_OR_CLOSE_FRIEND = "Family_or_Close_Friend";

	


	public static Date getDate(String date){
		try {
			return format.parse(date);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
}
