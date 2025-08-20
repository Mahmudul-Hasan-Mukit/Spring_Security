package com.Mukit.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
	@GetMapping("/")
public String hello() {
	return "Hi My name is Mukit";
}
}
