package com.openlgu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OpenLguApplicaton {

	public static void main(String[] args) {
		SpringApplication.run(OpenLguApplicaton.class, args);
	}

}
