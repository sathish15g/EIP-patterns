package com.example.demo;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RoutingPrinciple {

	 private static  final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	    @Router(inputChannel = "inputChannel")
	    public String routeToChannel(Message message){


	    	BusBooking busBooking=(BusBooking)message.getPayload();
	        if(logger.isInfoEnabled()){
	            logger.info("busBooking {}",busBooking);
	        }
	        switch (busBooking.getBookingStatus()){

	            case PENDING: return "bookingPendingChannel";
	            case BOOKED: return "bookingSuccessChannel";
	            case CANCELED: return "bookingCancelChannel";
	            default : return "bookingPendingChannel";
	        }
	    }
}
