package com.unit.conversion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class UnitConversionApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UnitConversionApplication.class).properties(
				"application-run-mode:external-container");
	}


	public static void main(String[] args) {
		new SpringApplicationBuilder(UnitConversionApplication.class).properties(
				"application-run-mode:embedded-container").run(args);
	}
}
