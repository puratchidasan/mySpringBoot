package com.tavant.spring.boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.tavant.spring.boot.model.Quote;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	//@Value("${bye.message:test}")
	private String byemessage = "Bye World";

	@RequestMapping("/sayhello")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		model.put("byemessage", this.byemessage);
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		model.put("quote", quote.toString());
		
		return "welcome";
	}

}