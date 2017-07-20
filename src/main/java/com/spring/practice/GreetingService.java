package com.spring.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingService {

	@Value("${message}")
	private String message;
	
	@GetMapping(value="/message")
	public String getMessage(){
		return message;
	}
	
}
