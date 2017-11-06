package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class EaiPublishSubscriberPatternApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EaiPublishSubscriberPatternApplication.class, args);
	}

	@Autowired
	@Qualifier("publishchannel")
	MessageChannel publishchannel;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		publishchannel.send(MessageBuilder.withPayload("Hi Publish Subscribe channel").build());
	}
}
