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

}
