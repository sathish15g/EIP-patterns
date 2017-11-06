package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class EiaTransformerPatternApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EiaTransformerPatternApplication.class, args);
	}

	@Autowired
	MessageChannel inputChannel;

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
	    Inventory inventory = new Inventory(1L, "FILA Shoes", 2);
		inputChannel.send(MessageBuilder.withPayload(inventory).build());
	}
}
