package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.ItemDaoMysql;
import com.qa.ims.persistence.dao.OrdersDaoMysql;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.ItemServices;
import com.qa.ims.services.OrdersServices;
import com.qa.ims.utils.Utils;


public class Ims {
	
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	/** I have used a Logger object as it is used to log messages for a specific system component.Loggers are normally named using a hierarchical dot-separated namespace.
	 * 
	 */
	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = Utils.getInput();
		LOGGER.info("What is your password");
		String password = Utils.getInput();
		
		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();
		
		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		Action.printActions();
		Action action = Action.getAction();
		
		switch (domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(new CustomerServices(new CustomerDaoMysql(username, password)));
			doAction(customerController, action);
			break;
		case PETSHOP:
			ItemController ItemController = new ItemController(new ItemServices(new ItemDaoMysql(username, password)));
			doAction(ItemController, action);
			break;
	
		case ORDER:
			OrdersController ordersController = new OrdersController(new OrdersServices(new OrdersDaoMysql(username, password)));
			doAction(ordersController, action);
			break;
		case STOP:
			break;
		default:
			break;
		}
		
	}
	
	public void doAction(CrudController crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
}
