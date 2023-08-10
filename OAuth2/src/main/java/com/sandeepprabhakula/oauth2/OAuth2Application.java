package com.sandeepprabhakula.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class OAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}

	@GetMapping
	public String welcome(){
		return "Welcome to OAuth2";
	}

	@GetMapping("/user")
	public Principal user(Principal principal){
		System.out.println(principal.getName());
		return principal;
	}
}
