package com.qa.ims.persistence.dao;
	import static org.junit.Assert.assertTrue;

	import java.util.List;

	import org.junit.Test;

	import com.qa.ims.persistence.domain.Orders;
public class OrdersDaoMysqllT {
	





		@Test
		public void testDatabaseHasValues() {
			OrdersDaoMysql ordersDaoMysql = new OrdersDaoMysql("root", "root");
			List<Orders> orders = ordersDaoMysql.readAll();
			assertTrue(orders.size()>0);
			
		}
	}

/**
* Mockito is a mocking framework, JAVA-based library that is used for effective unit testing of JAVA applications. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.
*/

