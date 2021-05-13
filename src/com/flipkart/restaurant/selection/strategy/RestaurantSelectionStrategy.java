package com.flipkart.restaurant.selection.strategy;

import java.util.List;

import com.flipkart.restaurant.Restaurant;
import com.flipkart.restaurant.order.OrderItem;
import com.flipkart.restaurant.order.RestaurantItem;

public interface RestaurantSelectionStrategy {

	List<RestaurantItem> selectRestaurant(List<OrderItem> item, List<Restaurant> restaurants);
	
}
