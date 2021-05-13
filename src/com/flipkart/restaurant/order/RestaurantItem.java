package com.flipkart.restaurant.order;

import com.flipkart.restaurant.Item;
import com.flipkart.restaurant.Restaurant;

public class RestaurantItem {

	Restaurant restaurant;
	Item item;
	int count;
	
	public RestaurantItem(Restaurant restaurant, Item item) {
		this.restaurant = restaurant;
		this.item = item;
	}
	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}