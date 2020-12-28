package com.lalit.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


//ask

@Service
public class LocaleService {

	 @Autowired
	    private MessageSource messageSource;

	    public String getMessage(String code) {
	        Locale locale = LocaleContextHolder.getLocale();
	        return this.messageSource.getMessage(code, null, locale);
	    }

	    public String getMessage(String code, Object... args) {
	        Locale locale = LocaleContextHolder.getLocale();
	        return this.messageSource.getMessage(code, args, locale);
	    }
}
