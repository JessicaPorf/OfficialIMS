package com.qa.ims.persistence.dao;
	import static org.junit.Assert.assertTrue;

	import java.util.List;

	import org.junit.Test;


import com.qa.ims.persistence.domain.Item;
public class ItemDaoMysqllT {




	

		@Test
		public void testDatabaseHasValues() {
			ItemDaoMysql ItemDaoMysql 	= new ItemDaoMysql("root", "root");
				 List<Item> item= ItemDaoMysql.readAll();
			assertTrue(Item.size()>0);

			
		}
	}




