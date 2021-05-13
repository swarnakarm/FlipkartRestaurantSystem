package com.flipkart.restaurant.selection.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.flipkart.restaurant.Restaurant;
import com.flipkart.restaurant.order.OrderItem;
import com.flipkart.restaurant.order.RestaurantItem;

public class LowCostStrategy implements RestaurantSelectionStrategy {

	@Override
	public List<RestaurantItem> selectRestaurant(List<OrderItem> orderItems, List<Restaurant> restaurants) {
		List<RestaurantItem> result = new ArrayList<>();
		for (OrderItem orderItem : orderItems) {
			PriorityQueue<RestaurantItem> minHeap = new PriorityQueue<>(10,
					new java.util.Comparator<RestaurantItem>() {
						@Override
						public int compare(RestaurantItem o1, RestaurantItem o2) {
							return Integer.compare(o1.getItem().getItemPrice(), o2.getItem().getItemPrice());
						}
					});
			for (Restaurant restaurant : restaurants) {
				 if(restaurant.capacity() > 0 && restaurant.getItem(orderItem.getItem()) != null ){
					 minHeap.add(new RestaurantItem(restaurant, restaurant.getItem(orderItem.getItem())));
				 }
			}
			if(!minHeap.isEmpty()){
				int quantity = orderItem.getQuantity();
				while(quantity>0 && !minHeap.isEmpty()){
					RestaurantItem restItem = minHeap.remove();
					int capacity = restItem.getRestaurant().capacity();
					restItem.setCount(Math.min(quantity, capacity));
					result.add(restItem);
					quantity-=capacity;
				}
			}
		}
		return result;
	}

}
