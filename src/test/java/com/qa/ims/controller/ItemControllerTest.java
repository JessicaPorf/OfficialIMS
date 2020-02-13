package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the item controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> item = new ArrayList<>();
		item.add(new Item("Cat", "1"));
		item.add(new Item("Rat", "2"));
		item.add(new Item("Mouse", "3"));
		Mockito.when(itemServices.readAll()).thenReturn(item);
		assertEquals(item, itemController.readAll());
	}

	@Test
	public void createTest() {
		String item_Name = "Cat";
		String item_Value = "1";
		Mockito.doReturn(item_Name, item_Value).when(itemController).getInput();
		Item item = new Item(item_Name, item_Value);
		Item savedItem = new Item(1L, "1", "1");
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	@Test
	public void updateTest() {
		String id = "1";
		String item_Name = "Cat";
		String item_Value = "1";
		Mockito.doReturn(id, item_Name, item_Value).when(itemController).getInput();
		Item item = new Item(1L, item_Name, item_Value);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
	
}

