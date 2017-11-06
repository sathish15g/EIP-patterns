package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderUtility implements Orderservice {

	@Autowired
	private OrderRespository orderRespository;

	@Override
	public Order getOrderItemById(long orderId) {
		Order order = orderRespository.findByOrderID(orderId);
		return order;
	}

	@Override
	public Order saveOrder(Order commodity) {
		Order created = orderRespository.save(commodity);
		return created;
	}

	@Override
	public Order updateOrder(Order update) {

		Order updatedOrder = orderRespository.save(update);
		
		return updatedOrder;
	}

	@Override
	public Order deleteOrder(Long id) {
		Order detetedOrder = orderRespository.delete(id);
		return detetedOrder;
	}

}
