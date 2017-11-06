package com.example.demo;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class InputServiceHandler {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public String toJson(String inventoryJson) throws MessagingException {

		if (inventoryJson != null && logger.isInfoEnabled()) {
			logger.info("inventory json service handler  {}", inventoryJson);
		}

		return inventoryJson;

	}

	public Inventory fromJson(Inventory inventory) throws MessagingException {

		if (inventory != null && logger.isInfoEnabled()) {
			logger.info("inventory object {}", inventory.toString());
		}

		return inventory;

	}

}