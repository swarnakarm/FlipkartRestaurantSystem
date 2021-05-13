package com.flipkart.restaurant.selection.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.flipkart.restaurant.Restaurant;
import com.flipkart.restaurant.order.OrderItem;
import com.flipkart.restaurant.order.RestaurantItem;

public class HighRatingStrategy implements RestaurantSelectionStrategy{

	@Override
	public List<RestaurantItem> selectRestaurant(List<OrderItem> orderItems, List<Restaurant> restaurants) {
		List<RestaurantItem> result = new ArrayList<>();
		for (OrderItem orderItem : orderItems) {
			PriorityQueue<RestaurantItem> maxHeap = new PriorityQueue<>(10,
					new java.util.Comparator<RestaurantItem>() {
						@Override
						public int compare(RestaurantItem o1, RestaurantItem o2) {
							//o2 compare with o1 as higher should be above.
							return Integer.compare(o2.getRestaurant().getRating(), o1.getRestaurant().getRating());
						}
					});
			for (Restaurant restaurant : restaurants) {
				 if(restaurant.capacity() > 0 && restaurant.getItem(orderItem.getItem()) != null ){
					 maxHeap.add(new RestaurantItem(restaurant, restaurant.getItem(orderItem.getItem())));
				 }
			}
			if(!maxHeap.isEmpty()){
				int quantity = orderItem.getQuantity();
				while(quantity>0 && !maxHeap.isEmpty()){
					RestaurantItem restItem = maxHeap.remove();
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
