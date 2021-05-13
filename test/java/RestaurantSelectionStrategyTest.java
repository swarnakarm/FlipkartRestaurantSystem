import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.flipkart.restaurant.Item;
import com.flipkart.restaurant.Restaurant;
import com.flipkart.restaurant.RestaurantSystem;
import com.flipkart.restaurant.exception.OrderFulfillmentException;
import com.flipkart.restaurant.order.OrderDetail;
import com.flipkart.restaurant.order.OrderItem;
import com.flipkart.restaurant.order.RestaurantItem;
import com.flipkart.restaurant.selection.strategy.HighRatingStrategy;
import com.flipkart.restaurant.selection.strategy.LowCostStrategy;
import com.flipkart.restaurant.selection.strategy.RestaurantSelectionStrategy;

public class RestaurantSelectionStrategyTest {

	@Test
	public void highRatingStrategyTest() throws Exception{
		
		
		RestaurantSelectionStrategy selectionStrategy = new HighRatingStrategy();
		RestaurantSystem rSystem = new RestaurantSystem(selectionStrategy);
		Restaurant r1 = new Restaurant("r1", 2, 5);
		Item item1 = new Item("i1",10 );
		r1.addItem(item1);
		Item item2 = new Item("i2",10 );
		r1.addItem(item2);
		Item item3 = new Item("i3",10 );
		r1.addItem(item3);
		Item item4 = new Item("i4",10 );
		r1.addItem(item4);
		Item item5 = new Item("i5",10 );
		r1.addItem(item5);
		Item item6 = new Item("i6",10 );
		r1.addItem(item6);
		Item item7 = new Item("i7",10 );
		r1.addItem(item7);
		Item item8 = new Item("i8",10 );
		r1.addItem(item8);
		Item item9 = new Item("i9",10 );
		r1.addItem(item9);
		Item item10 = new Item("i10",10 );
		r1.addItem(item10);
		Item item11 = new Item("i11",10 );
		r1.addItem(item11);
		
		rSystem.registerRestaurant(r1);
		
		
		Restaurant r2 = new Restaurant("r2", 1, 2);
		
		Item item1_ = new Item("i1",8 );
		r2.addItem(item1_);
		Item item2_ = new Item("i2",8 );
		r2.addItem(item2_);
		Item item3_ = new Item("i3",8 );
		r2.addItem(item3_);
		Item item4_ = new Item("i4",8 );
		r2.addItem(item4_);
		Item item5_ = new Item("i5",8 );
		r2.addItem(item5_);
		rSystem.registerRestaurant(r2);
		
		Restaurant r3 = new Restaurant("r3", 1, 5);
		Item item1__ = new Item("i1",12 );
		r3.addItem(item1__);
		Item item2__ = new Item("i2",12 );
		r3.addItem(item2__);
		Item item3__ = new Item("i3",12 );
		r3.addItem(item3__);
		Item item4__ = new Item("i4",12 );
		r3.addItem(item4__);
		Item item5__ = new Item("i5",12 );
		r3.addItem(item5__);
		rSystem.registerRestaurant(r3);
		
		
		List<OrderItem> orderItems1 = new ArrayList<>();
		orderItems1.add(new OrderItem("i1",3));
		 OrderDetail orderDtl1 = rSystem.order(orderItems1);
		 System.out.println("OrderId :: "+orderDtl1.getOrderId());
		 for(RestaurantItem restItem :orderDtl1.getRestItems()){
			 System.out.println(restItem.getRestaurant().getName());
			 System.out.println(restItem.getItem().getItemName());
			 System.out.println(restItem.getCount());
		 }
		 
		 System.out.println();
		 System.out.println();
		 System.out.println("------------------------");
	}
	
	
	
	/**
	 * OrderFulfillmentException
	 * @throws Exception
	 */
	@Test(expected = OrderFulfillmentException.class)
	public void highRatingStrategyTest_2() throws Exception{
		
		
		RestaurantSelectionStrategy selectionStrategy = new HighRatingStrategy();
		RestaurantSystem rSystem = new RestaurantSystem(selectionStrategy);
		Restaurant r1 = new Restaurant("r1", 2, 5);
		Item item1 = new Item("i1",10 );
		r1.addItem(item1);
		Item item2 = new Item("i2",10 );
		r1.addItem(item2);
		Item item3 = new Item("i3",10 );
		r1.addItem(item3);
		Item item4 = new Item("i4",10 );
		r1.addItem(item4);
		Item item5 = new Item("i5",10 );
		r1.addItem(item5);
		Item item6 = new Item("i6",10 );
		r1.addItem(item6);
		Item item7 = new Item("i7",10 );
		r1.addItem(item7);
		Item item8 = new Item("i8",10 );
		r1.addItem(item8);
		Item item9 = new Item("i9",10 );
		r1.addItem(item9);
		Item item10 = new Item("i10",10 );
		r1.addItem(item10);
		Item item11 = new Item("i11",10 );
		r1.addItem(item11);
		
		rSystem.registerRestaurant(r1);
		
		
		Restaurant r2 = new Restaurant("r2", 1, 2);
		
		Item item1_ = new Item("i1",8 );
		r2.addItem(item1_);
		Item item2_ = new Item("i2",8 );
		r2.addItem(item2_);
		Item item3_ = new Item("i3",8 );
		r2.addItem(item3_);
		Item item4_ = new Item("i4",8 );
		r2.addItem(item4_);
		Item item5_ = new Item("i5",8 );
		r2.addItem(item5_);
		rSystem.registerRestaurant(r2);
		
		Restaurant r3 = new Restaurant("r3", 1, 5);
		Item item1__ = new Item("i1",12 );
		r3.addItem(item1__);
		Item item2__ = new Item("i2",12 );
		r3.addItem(item2__);
		Item item3__ = new Item("i3",12 );
		r3.addItem(item3__);
		Item item4__ = new Item("i4",12 );
		r3.addItem(item4__);
		Item item5__ = new Item("i5",12 );
		r3.addItem(item5__);
		rSystem.registerRestaurant(r3);
		
		
		List<OrderItem> orderItems1 = new ArrayList<>();
		orderItems1.add(new OrderItem("i1",3));
		 OrderDetail orderDtl1 = rSystem.order(orderItems1);
		 System.out.println("OrderId :: "+orderDtl1.getOrderId());
		 for(RestaurantItem restItem :orderDtl1.getRestItems()){
			 System.out.println(restItem.getRestaurant().getName());
			 System.out.println(restItem.getItem().getItemName());
			 System.out.println(restItem.getCount());
		 }
		 
		 System.out.println();
		 System.out.println();
		 System.out.println("------------------------");
		 List<OrderItem> orderItems2 = new ArrayList<>();
			orderItems2.add(new OrderItem("i1",3));
			 OrderDetail orderDtl2 = rSystem.order(orderItems2);
			 System.out.println("OrderId :: "+orderDtl2.getOrderId());
			 for(RestaurantItem restItem :orderDtl2.getRestItems()){
				 System.out.println(restItem.getRestaurant().getName());
				 System.out.println(restItem.getItem().getItemName());
				 System.out.println(restItem.getCount());
			 }
	}
	
	
	@Test
	public void lowCostStrategy_1() throws Exception {
		RestaurantSelectionStrategy selectionStrategy = new LowCostStrategy();
		RestaurantSystem rSystem = new RestaurantSystem(selectionStrategy);
		Restaurant r1 = new Restaurant("r1", 2, 5);
		Item item1 = new Item("i1",10 );
		r1.addItem(item1);
		Item item2 = new Item("i2",10 );
		r1.addItem(item2);
		Item item3 = new Item("i3",10 );
		r1.addItem(item3);
		Item item4 = new Item("i4",10 );
		r1.addItem(item4);
		Item item5 = new Item("i5",10 );
		r1.addItem(item5);
		Item item6 = new Item("i6",10 );
		r1.addItem(item6);
		Item item7 = new Item("i7",10 );
		r1.addItem(item7);
		Item item8 = new Item("i8",10 );
		r1.addItem(item8);
		Item item9 = new Item("i9",10 );
		r1.addItem(item9);
		Item item10 = new Item("i10",10 );
		r1.addItem(item10);
		Item item11 = new Item("i11",10 );
		r1.addItem(item11);
		
		rSystem.registerRestaurant(r1);
		
		
		Restaurant r2 = new Restaurant("r2", 1, 2);
		
		Item item1_ = new Item("i1",8 );
		r2.addItem(item1_);
		Item item2_ = new Item("i2",8 );
		r2.addItem(item2_);
		Item item3_ = new Item("i3",8 );
		r2.addItem(item3_);
		Item item4_ = new Item("i4",8 );
		r2.addItem(item4_);
		Item item5_ = new Item("i5",8 );
		r2.addItem(item5_);
		rSystem.registerRestaurant(r2);
		
		Restaurant r3 = new Restaurant("r3", 1, 5);
		Item item1__ = new Item("i1",12 );
		r3.addItem(item1__);
		Item item2__ = new Item("i2",12 );
		r3.addItem(item2__);
		Item item3__ = new Item("i3",12 );
		r3.addItem(item3__);
		Item item4__ = new Item("i4",12 );
		r3.addItem(item4__);
		Item item5__ = new Item("i5",12 );
		r3.addItem(item5__);
		rSystem.registerRestaurant(r3);
		
		
		List<OrderItem> orderItems1 = new ArrayList<>();
		orderItems1.add(new OrderItem("i1",3));
		 OrderDetail orderDtl1 = rSystem.order(orderItems1);
		 System.out.println("OrderId :: "+orderDtl1.getOrderId());
		 for(RestaurantItem restItem :orderDtl1.getRestItems()){
			 System.out.println(restItem.getRestaurant().getName());
			 System.out.println(restItem.getItem().getItemName());
			 System.out.println(restItem.getCount());
		 }
		 
	}
	
	
	@Test(expected = OrderFulfillmentException.class)
	public void lowCostStrategy_2() throws Exception {
		RestaurantSelectionStrategy selectionStrategy = new LowCostStrategy();
		RestaurantSystem rSystem = new RestaurantSystem(selectionStrategy);
		Restaurant r1 = new Restaurant("r1", 2, 5);
		Item item1 = new Item("i1",10 );
		r1.addItem(item1);
		Item item2 = new Item("i2",10 );
		r1.addItem(item2);
		Item item3 = new Item("i3",10 );
		r1.addItem(item3);
		Item item4 = new Item("i4",10 );
		r1.addItem(item4);
		Item item5 = new Item("i5",10 );
		r1.addItem(item5);
		Item item6 = new Item("i6",10 );
		r1.addItem(item6);
		Item item7 = new Item("i7",10 );
		r1.addItem(item7);
		Item item8 = new Item("i8",10 );
		r1.addItem(item8);
		Item item9 = new Item("i9",10 );
		r1.addItem(item9);
		Item item10 = new Item("i10",10 );
		r1.addItem(item10);
		Item item11 = new Item("i11",10 );
		r1.addItem(item11);
		
		rSystem.registerRestaurant(r1);
		
		
		Restaurant r2 = new Restaurant("r2", 1, 2);
		
		Item item1_ = new Item("i1",8 );
		r2.addItem(item1_);
		Item item2_ = new Item("i2",8 );
		r2.addItem(item2_);
		Item item3_ = new Item("i3",8 );
		r2.addItem(item3_);
		Item item4_ = new Item("i4",8 );
		r2.addItem(item4_);
		Item item5_ = new Item("i5",8 );
		r2.addItem(item5_);
		rSystem.registerRestaurant(r2);
		
		Restaurant r3 = new Restaurant("r3", 1, 5);
		Item item1__ = new Item("i1",12 );
		r3.addItem(item1__);
		Item item2__ = new Item("i2",12 );
		r3.addItem(item2__);
		Item item3__ = new Item("i3",12 );
		r3.addItem(item3__);
		Item item4__ = new Item("i4",12 );
		r3.addItem(item4__);
		Item item5__ = new Item("i5",12 );
		r3.addItem(item5__);
		rSystem.registerRestaurant(r3);
		
		
		List<OrderItem> orderItems1 = new ArrayList<>();
		orderItems1.add(new OrderItem("i1",3));
		 OrderDetail orderDtl1 = rSystem.order(orderItems1);
		 System.out.println("OrderId :: "+orderDtl1.getOrderId());
		 for(RestaurantItem restItem :orderDtl1.getRestItems()){
			 System.out.println(restItem.getRestaurant().getName());
			 System.out.println(restItem.getItem().getItemName());
			 System.out.println(restItem.getCount());
		 }
		 
		 System.out.println();
		 System.out.println();
		 System.out.println("------------------------");
		 List<OrderItem> orderItems2 = new ArrayList<>();
			orderItems2.add(new OrderItem("i1",3));
			 OrderDetail orderDtl2 = rSystem.order(orderItems2);
			 System.out.println("OrderId :: "+orderDtl2.getOrderId());
			 for(RestaurantItem restItem :orderDtl2.getRestItems()){
				 System.out.println(restItem.getRestaurant().getName());
				 System.out.println(restItem.getItem().getItemName());
				 System.out.println(restItem.getCount());
			 }
	}
	
}
