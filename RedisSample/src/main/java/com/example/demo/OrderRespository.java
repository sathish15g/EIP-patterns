package com.example.demo;

import java.util.Collection;

import org.springframework.data.repository.Repository;

public interface OrderRespository extends Repository<Order, Long> {

	Collection<Order> findByProductName(String productName);	

	Order save(Order saved);

	Order findByOrderID(Long orderId);
	
	Order delete(Long orderId);
}
	