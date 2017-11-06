package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private Orderservice orderservice;

	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	@Cacheable("byID")
	public Order byID(@PathVariable("orderId") Long orderId) {

		Order productRes = orderservice.getOrderItemById(orderId);

		return productRes;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Order placeOrder(@RequestBody Order orderSample) {
		return orderservice.saveOrder(orderSample);
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order orderSample) {
		return orderservice.saveOrder(orderSample);
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	public Order deteOrder(@PathVariable("id") Long Id) {
		return orderservice.deleteOrder(Id);
	}

}
