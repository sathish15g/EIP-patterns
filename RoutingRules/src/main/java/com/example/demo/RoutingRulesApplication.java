package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class RoutingRulesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RoutingRulesApplication.class, args);
	}

	@Autowired
	MessageChannel inputChannel;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Message<BusBooking> canceled = MessageBuilder.withPayload(new BusBooking("PNR123", "SATHISH", BookingStatus.CANCELED)).build();
		Message<BusBooking> booked = MessageBuilder.withPayload(new BusBooking("PNR123", "SRI", BookingStatus.BOOKED)).build();
		Message<BusBooking> pending = MessageBuilder.withPayload(new BusBooking("PNR123", "RAM", BookingStatus.PENDING)).build();
		inputChannel.send(canceled);
		inputChannel.send(booked);
		inputChannel.send(pending);
	}
}
