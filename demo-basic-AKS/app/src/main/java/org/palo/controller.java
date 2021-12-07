package org.palo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/appname")
	public String appName() {
		return appName;
	}

	@GetMapping("/")
	public String example() {
		return "Hello World !!";
	}
}
