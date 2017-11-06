package com.example.demo;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class SubscriberTwo implements MessageHandler {

	final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		// TODO Auto-generated method stub
		if (logger.isInfoEnabled()) {
			logger.info("Message recevied at SUBSCRIBER 1 {}", message.toString());
		}

	}

}
