package com.example.demo;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class InputHandler implements MessageHandler {

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		// TODO Auto-generated method stub
		final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
		
		if(logger.isInfoEnabled()){
			logger.info("Message recevied {}",message.toString());
		}
	}

}
