package com.qa.ims.persistence.dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.log4j.Logger;

	import com.qa.ims.persistence.domain.Orders;

	public class OrdersDaoMysql implements Dao<Orders> {

		public static final Logger LOGGER = Logger.getLogger(OrdersDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public OrdersDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://34.89.13.205:3306/projectIMS";
			this.username = username;
			this.password = password;
		}

		public OrdersDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}

		Orders ordersFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("id");
			String customer_id  = resultSet.getString("customer_id ");
			return new Orders(id, customer_id );
		}
		/**
		 * Reads all orders from the database
		 * 
		 * @return A list of orders
		 */
		@Override
		public List<Orders> readAll() {
			try (Connection connection = DriverManager
					.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
				ArrayList<Orders> orders = new ArrayList<>();
				while (resultSet.next()) {
					orders.add(ordersFromResultSet(resultSet));
				}
				return orders;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Orders readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders BY id DESC LIMIT 1");) {
				resultSet.next();
				return ordersFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Creates orders in the database
		 * 
		 * @param orders - takes in orders object. id will be ignored
		 */
		@Override
		public Orders create(Orders orders) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into orders(customer_id ) values('" + orders.getcustomer_id () + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		
		public Orders readOrders(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where id = "+id);) {
				resultSet.next();
				return ordersFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Updates orders in the database
		 * 
		 * @param orders - takes in a orders object, the id field will be used to
		 *                 update that order in the database
		 * @return 
		 */
		@Override
		public Orders update(Orders orders) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update orders set customer_id  ='"
						+ orders.getcustomer_id () + "' where id =" + orders.getId());
				return readOrders(orders.getId());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Deletes a order in the database
		 * 
		 * @param id - id of the order
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orders where id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

		

	}


