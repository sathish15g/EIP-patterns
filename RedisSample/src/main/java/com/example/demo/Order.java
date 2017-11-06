package com.example.demo;

import java.io.Serializable;
import java.lang.reflect.Constructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class Order implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4160786511688966842L;

	/**
	 * Default {@link Constructor} for creating instances of OrderItems.
	 */
	public Order(){
		//Default constructor
	}

	/**
	 * Overloaded constructor for OrderItems with params.
	 * 
	 * @param orderID order id
	 */
	public Order(Long orderID) {
		super();
		this.orderID = orderID;

	}


	@Id
	@GeneratedValue
	@Column(name="orderid")
	private Long orderID;

	@Column
	private Long clientId;

	@Column
	private String productName;

	@Column
	private String locationName;

	@Column
	private String status;

	@Column(unique = true)
	private String externalRef;

	@Column
	private Long quantity;

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExternalRef() {
		return externalRef;
	}

	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}