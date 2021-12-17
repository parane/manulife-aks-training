package org.palo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@Value("${SPRING_APPLICATION_NAME}")
	String appAction;


	@GetMapping("/action")
	public String appAction() {
		String designAction = "I am " + appAction + "ing";
		return designAction;
	}


	@GetMapping("/")
	public String example() {
		return "Hello World!!";
	}
}
