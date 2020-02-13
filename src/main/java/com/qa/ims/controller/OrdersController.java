package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

//import com.qa.ims.OrdersServices;
import com.qa.ims.persistence.domain.Orders;
	import com.qa.ims.services.CrudServices;
	import com.qa.ims.utils.Utils;
	/**
	 * I have an orders controller which essentially controls the orders in the project.
	 * I used CRUD functionality for my orders below.
	 *
	 */
	/**
	 * Takes in order details for CRUD functionality
	 *
	 */
	public class OrdersController implements CrudController<Orders>{

		public static final Logger LOGGER = Logger.getLogger(OrdersController.class);
		
		private CrudServices<Orders> ordersService;
		
		public OrdersController(com.qa.ims.services.OrdersServices ordersServices) {
			this.ordersService = ordersServices;
		}
		
	
		

		String getInput() {
			return Utils.getInput();
		}
		
		/**
		 * Reads all orders to the logger
		 */
		@Override
		public List<Orders> readAll() {
			List<Orders> orders = ordersService.readAll();
			for(Orders order: orders) {
				LOGGER.info(orders.toString());
			}
			return orders;
		}

		/**
		 * Creates an order by taking in user input
		 */
		@Override
		public Orders create() {
			LOGGER.info("Please enter a customer_id ");
			String customer_id  = getInput();
			Orders orders = ordersService.create(new Orders(customer_id ));
			LOGGER.info("Orders created");
			return orders;
		}

		/**
		 * Updates an existing order by taking in user input
		 */
		@Override
		public Orders update() {
			LOGGER.info("Please enter the id of the order you would like to update");
			Long id = Long.valueOf(getInput());
			LOGGER.info("Please enter a customer_id ");
			String customer_id  = getInput();
			Orders orders = ordersService.update(new Orders(id, customer_id ));
			LOGGER.info("Orders Updated");
			return orders;
		}

		/**
		 * Deletes an existing order by the id of the customer
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the orders you would like to delete");
			Long id = Long.valueOf(getInput());
			ordersService.delete(id);
		}
		
	}


