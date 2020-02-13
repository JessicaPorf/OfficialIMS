

	package com.qa.ims.services;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.Spy;
	import org.mockito.junit.MockitoJUnitRunner;

	import com.qa.ims.persistence.dao.Dao;
	import com.qa.ims.persistence.domain.Customer;

	
	@RunWith(MockitoJUnitRunner.class)
	public class CustomerServicesTest {
		
		@Mock
		private Dao<Customer> customerDao;
		
		@InjectMocks
		private CustomerServices customerServices;
		
		@Test
		public void customerServicesCreateTest() {
			Customer customer = new Customer("Jess", "L");
			customerServices.create(customer);
			Mockito.verify(customerDao, Mockito.times(1)).create(customer);
		}
		
		@Test
		public void customerServicesReadTest() {
			customerServices.readAll();
			Mockito.verify(customerDao, Mockito.times(1)).readAll();
		}
		
		@Test
		public void customerServicesUpdateTest() {
			Customer customer = new Customer("Jess", "L");
			customerServices.update(customer);
			Mockito.verify(customerDao, Mockito.times(1)).update(customer);
		}
		
		@Test
		public void customerServicesDeleteTest() {
			customerServices.delete(1L);;
			Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
		}
	}

