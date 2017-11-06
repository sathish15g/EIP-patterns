package com.example.demo;

public class Inventory {

	private Long inventoryId;
	
	private String inventoryName;

	private int quantity;

	@Override
	public String toString() {
		return "inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", quantity=" + quantity
				+ "]";
	}

	public Inventory(Long inventoryId, String inventoryName, int quantity) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.quantity = quantity;
	}

	public Inventory() {
		super();
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
