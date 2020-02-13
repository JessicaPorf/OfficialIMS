package com.qa.ims.controller;
	import java.util.ArrayList;
	import java.util.List;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.Spy;
	import org.mockito.junit.MockitoJUnitRunner;

	import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.OrdersServices;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	
	

		
		/**
		 *  The thing I want to fake functionality for
		 */
		@Mock
		private OrdersServices ordersServices;
		
		/**
		 * Spy is used because i want to mock some methods inside the order I'm testing
		 * InjectMocks uses dependency injection to insert the mock into the order controller
		 */
		@Spy
		@InjectMocks
		private OrdersController ordersController;

		@Test
		public void readAllTest() {
			OrdersController ordersController = new OrdersController(ordersServices);
			List<Orders> orders = new ArrayList<>();
			orders.add(new Orders("1"));
			orders.add(new Orders("2"));
			orders.add(new Orders("3"));
			Mockito.when(ordersServices.readAll()).thenReturn(orders);
			assertEquals(orders, ordersController.readAll());
		}

		@Test
		public void createTest() {
			String customer_id  = "1";
			Mockito.doReturn(customer_id ).when(ordersController).getInput();
			Orders orders = new Orders(customer_id );
			Orders savedOrders = new Orders(1L, "1");
			Mockito.when(ordersServices.create(orders)).thenReturn(savedOrders);
			assertEquals(savedOrders, ordersController.create());
		}

		@Test
		public void updateTest() {
			String id = "1";
			String customer_id  = "1";
			Mockito.doReturn(id, customer_id ).when(ordersController).getInput();
		    Orders orders = new Orders(1L, customer_id );
			Mockito.when(ordersServices.update(orders)).thenReturn(orders);
			assertEquals(orders, ordersController.update());
		}
		

		/**
		 * Delete doesn't return anything, so we can just verify that it calls the delete method
		 */
		@Test
		public void deleteTest() {
			String id = "1";
			Mockito.doReturn(id).when(ordersController).getInput();
			ordersController.delete();
			Mockito.verify(ordersServices, Mockito.times(1)).delete(1L);
		
		
	}}

