package com.flipkart.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flipkart.restaurant.exception.OrderFulfillmentException;
import com.flipkart.restaurant.order.OrderDetail;
import com.flipkart.restaurant.order.OrderItem;
import com.flipkart.restaurant.order.RestaurantItem;
import com.flipkart.restaurant.selection.strategy.RestaurantSelectionStrategy;

public class RestaurantSystem {

	private Map<String, Restaurant> restaurants;
	//Cache
	private Map<String, Item> menu;
	private RestaurantSelectionStrategy selectionStrategy;

	public RestaurantSystem(RestaurantSelectionStrategy selectionStrategy) {
		restaurants = new HashMap<>();
		menu = new HashMap<>();
		this.selectionStrategy = selectionStrategy;
	}

	public void setSelectionStrategy(RestaurantSelectionStrategy selectionStrategy) {
		this.selectionStrategy = selectionStrategy;
	}

	public void registerRestaurant(Restaurant restaurant) {
		restaurants.put(restaurant.getName(), restaurant);
		for (Map.Entry<String, Item> itemEntry : restaurant.getMenu().entrySet()) {
			if (!menu.containsKey(itemEntry.getKey())) {
				menu.put(itemEntry.getKey(), itemEntry.getValue());
			}
		}
	}

	Map<String, Item> fetchItems() {
		return menu;
	}

	public OrderDetail order(List<OrderItem> orderItems) throws OrderFulfillmentException {
		List<RestaurantItem> fulfillmentItems = selectionStrategy.selectRestaurant(orderItems,
				new ArrayList<>(restaurants.values()));
		int totalOrderItemsCount = orderItems.stream().mapToInt(orderItem -> orderItem.getQuantity()).sum();
		int fulfillmentCount = fulfillmentItems.stream().mapToInt(fulfillmentItem -> fulfillmentItem.getCount()).sum();
		if (totalOrderItemsCount == fulfillmentCount) {
			for (RestaurantItem fulfillmentItem : fulfillmentItems) {
				for (int i = 0; i < fulfillmentItem.getCount(); i++) {
					fulfillmentItem.getRestaurant().order(fulfillmentItem.getItem());
				}
			}
			return new OrderDetail(fulfillmentItems);
		}
		throw new OrderFulfillmentException("Order cannot be fulfilled.");
	}
	
	
//	public OrderDetail order(List<OrderItem> orderItems) throws OrderFulfillmentException {
//		List<RestaurantItem> fulfillmentItems = selectionStrategy.selectRestaurant(orderItems,
//				new ArrayList<>(restaurants.values()));
//		int totalOrderItemsCount = orderItems.stream().mapToInt(orderItem -> orderItem.getQuantity()).sum();
//		int fulfillmentCount = fulfillmentItems.stream().mapToInt(fulfillmentItem -> fulfillmentItem.getCount()).sum();
//		if (totalOrderItemsCount == fulfillmentCount) {
//			for (RestaurantItem fulfillmentItem : fulfillmentItems) {
//				for (int i = 0; i < fulfillmentItem.getCount(); i++) {
//					fulfillmentItem.getRestaurant().order(fulfillmentItem.getItem());
//				}
//			}
//			return new OrderDetail(fulfillmentItems);
//		}
//		throw new OrderFulfillmentException("Order cannot be fulfilled.");
//	}

}