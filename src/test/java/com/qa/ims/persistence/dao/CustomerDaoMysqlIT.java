package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlIT {

	@Test
	public void testDatabaseHasValues() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "root");
		List<Customer> customers = customerDaoMysql.readAll();
		assertTrue(customers.size()>0);
		
	}
}

/*
*Mockito is a mocking framework, JAVA-based library that is used for effective unit testing of JAVA applications. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.
*/