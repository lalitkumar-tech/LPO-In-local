package com.lalit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class EnvVariables {

	 @Value("${lpo.local.max-emergency-contact}")
	    private int maxEmergencyContact;
	 
}
