package com.flipkart.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {

	private Map<String, Item> menu;
	private String name;
	private AtomicInteger counter;
	private Queue<Item> capacityQueue; 
	private int rating;
	private int capacity;
	
	public Restaurant(String name, int capacity, int rating){
		this.name = name;
		this.capacityQueue = new ArrayBlockingQueue<>(capacity); 
		this.rating = rating;
		this.menu = new HashMap<>();
		counter = new AtomicInteger(0);
		this.capacity = capacity;
	}
	
	public Map<String, Item> getMenu() {
		return menu;
	}

	public Item getItem(String name) {
		return menu.get(name);
	}
	public void addItem(Item item) {
		this.menu.put(item.getItemName(), item);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int capacity(){
		return capacity - counter.get();
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean order(Item item){
		synchronized(capacityQueue){
			if(capacity - counter.get() > 0){
				capacityQueue.add(item);
				counter.incrementAndGet();
				return true;
			} 
		}
		return false;
	}
	
	public void dispatch(){
		synchronized(capacityQueue){
			capacityQueue.remove();
			counter.decrementAndGet();
		}
	}
	
}