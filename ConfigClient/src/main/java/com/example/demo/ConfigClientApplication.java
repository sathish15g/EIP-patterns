package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {
	
	@Value("${name:test}")
	private String name;
	
	@Value("${age:0}")
	private int age;
	

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Name"+name);
		System.out.println("Age"+age);
		
	}
}
