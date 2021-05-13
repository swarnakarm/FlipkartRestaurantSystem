package com.flipkart.restaurant.order;

public class OrderItem {

	public OrderItem(){}
	public OrderItem(String item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}
	String item;
	int quantity;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
