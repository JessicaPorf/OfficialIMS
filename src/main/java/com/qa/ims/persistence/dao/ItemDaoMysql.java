package com.qa.ims.persistence.dao;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.log4j.Logger;

	import com.qa.ims.persistence.domain.Item;
	

	public class ItemDaoMysql implements Dao<Item> {

		public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public ItemDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://34.89.13.205:3306/projectIMS";
			this.username = username;
			this.password = password;
		}

		public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}

		Item ItemFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("id");
			String item_Name = resultSet.getString("item_Name");
			String item_Value = resultSet.getString("item_Value");
			return new Item(id, item_Name, item_Value);
		}
		/**
		 * Reads all items from the database
		 * 
		 * @return A list of items
		 */
		@Override
		public List<Item> readAll() {
			try (Connection connection = DriverManager
					.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from item");) {
				ArrayList<Item> item = new ArrayList<>();
				while (resultSet.next()) {
					item.add(ItemFromResultSet(resultSet));
				}
				return item;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Item readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY id DESC LIMIT 1");) {
				resultSet.next();
				return ItemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Creates an item in the database
		 * 
		 * @param item - takes in a item object. id will be ignored
		 */
		@Override
		public Item create(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into item(item_Name, item_Value) values('" + item.getitem_Name()
						+ "','" + item.getitem_Value() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		
		public Item readItem(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT FROM item where id = "+id);) {
				resultSet.next();
				return ItemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Updates an item in the database
		 * 
		 * @param item - takes in a item object, the id field will be used to
		 *                 update that item in the database
		 * @return 
		 */
		@Override
		public Item update(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update item set item_Name ='" + item.getitem_Name() + "', item_Value ='"
						+ item.getitem_Value() + "' where id =" + item.getId());
				return readItem(item.getId());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Deletes an item in the database
		 * 
		 * @param id - id of the item
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from item where id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

	}


