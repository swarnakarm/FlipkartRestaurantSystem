package com.flipkart.restaurant.order;

import java.util.List;
import java.util.UUID;

public class OrderDetail {

	private String orderId;
	List<RestaurantItem> restItems;
	
	public OrderDetail(List<RestaurantItem> restItems){
		orderId = UUID.randomUUID().toString();
		this.restItems = restItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public List<RestaurantItem> getRestItems() {
		return restItems;
	}
	
}
