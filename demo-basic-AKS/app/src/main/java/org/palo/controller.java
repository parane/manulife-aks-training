package org.palo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@Value("${SPRING_APPLICATION_NAME}")
	String appName;

	@Value("${SPRING_APPLICATION_ENV}")
	String appEnv;


	@GetMapping("/appname")
	public String appName() {
		return appName;
	}


	@GetMapping("/appenv")
	public String appEnv() {
		return appEnv;
	}

	@GetMapping("/")
	public String example() {
		return "Hello World !!";
	}
}
