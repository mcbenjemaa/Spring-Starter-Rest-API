package com.enable.restfullapp;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class TutorielRestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorielRestfulWebservicesApplication.class, args);
	}
	
	
	// internalization -- languages 
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver session=new AcceptHeaderLocaleResolver();
		
		session.setDefaultLocale(Locale.US);
		
		
		return session;
		
	}
	
	
	/*@Bean 
	public  ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source=new ResourceBundleMessageSource();
		source.setBasename("messages");
		
		return source;
	}*/
	
}