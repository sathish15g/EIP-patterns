package com.example.demo;

public interface Orderservice {

	Order getOrderItemById(long orderId);

	Order saveOrder(Order commodity);
	
	Order updateOrder(Order update);
	
	Order deleteOrder(Long id);
}
