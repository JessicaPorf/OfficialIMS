package com.qa.ims.controller;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * I have an Item controller which essentially controls the item in the project.
 * I used CRUD functionality for my items below.
 *
 */

	
	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */
public class ItemController implements CrudController<Item>{

		public static final Logger LOGGER = Logger.getLogger(ItemController.class);
		
		private CrudServices<Item> ItemService;
		
		public ItemController(CrudServices<Item> itemService) {
			this.ItemService = itemService;
		}
		
		String getInput() {
			return Utils.getInput();
		}
		
		/**
		 * Reads all customers to the logger
		 */
		@Override
		public List<Item> readAll() {
			List<Item> item = ItemService.readAll();
			for(Item item1: item) {
				LOGGER.info(item1.toString());
			}
			return item;
		}

		/**
		 * Creates a customer by taking in user input
		 */
		@Override
		public Item create() {
			LOGGER.info("Please enter the item name");
			String item_Name = getInput();
			LOGGER.info("Please enter the item value");
			String item_Value = getInput();
			Item item = ItemService.create(new Item(item_Name, item_Value));
			LOGGER.info("item created");
			return item;
		}

		/**
		 * Updates an existing customer by taking in user input
		 */
		@Override
		public Item update() {
			LOGGER.info("Please enter the id of the item you would like to update");
			Long id = Long.valueOf(getInput());
			LOGGER.info("Please enter an item name");
			String item_Name = getInput();
			LOGGER.info("Please enter an item value");
			String item_Value = getInput();
			
			Item item = ItemService.update(new Item(id, item_Name, item_Value));
			LOGGER.info("Item Updated");
			return item;
		}

		/**
		 * Deletes an existing customer by the id of the customer
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long id = Long.valueOf(getInput());
			ItemService.delete(id);
		}
		
	}


