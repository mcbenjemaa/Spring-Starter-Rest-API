package com.enable.restfullapp.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired MessageSource messageSource;

	
	@GetMapping("/hello-world")
	public String helloworld() {
		return "Hello World!";
		
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello World!");
		
	}
	
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloworldbean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World!, %s", name));
		
	}
	
	
	
	@GetMapping("/hello-world-internalization")
	public String helloworldinternalization() {
		return messageSource.getMessage("good-morning-message",null, LocaleContextHolder.getLocale());
		
	}
}
