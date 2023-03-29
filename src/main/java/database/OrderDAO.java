package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Customer;
import models.Order;

public class OrderDAO implements DAOInterface<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> OrderList = new ArrayList<Order>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM order";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String OrderId = rs.getString("OrderId");
				String customerId = rs.getString("customerId");
				String status = rs.getString("status");
				String orderAddress = rs.getString("orderAddress");
				String shippingAddress = rs.getString("shippingAddress");
				String paymentMethod = rs.getString("paymentMethod");
				String paymentStatus = rs.getString("paymentStatus");
				double depositsAmount = rs.getDouble("depositsAmount");
				double restOfMoney = rs.getDouble("restOfMoney");
				Date orderDate = rs.getDate("orderDate");
				Date orderShipping = rs.getDate("orderShipping");
				
				Customer customer = new CustomerDAO()
										.selectById(new Customer(
												customerId, 
												"", "", "", "", "", "", "", null, "", "", null, false)) ;
				Order order = new Order(OrderId, customer, orderAddress, shippingAddress, status, paymentMethod, paymentStatus, depositsAmount, restOfMoney, orderDate, orderShipping);
				OrderList.add(order);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return OrderList;
	}

	@Override
	public Order selectById(Order t) {

		Order Order = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM order WHERE orderId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrderId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String OrderId = rs.getString("OrderId");
				String customerId = rs.getString("customerId");
				String status = rs.getString("status");
				String orderAddress = rs.getString("orderAddress");
				String shippingAddress = rs.getString("shippingAddress");
				String paymentMethod = rs.getString("paymentMethod");
				String paymentStatus = rs.getString("paymentStatus");
				double depositsAmount = rs.getDouble("depositsAmount");
				double restOfMoney = rs.getDouble("restOfMoney");
				Date orderDate = rs.getDate("orderDate");
				Date orderShipping = rs.getDate("orderShipping");
				
				Customer customer = new CustomerDAO()
										.selectById(new Customer(
												customerId, 
												"", "", "", "", "", "", "", null, "", "", null, false)) ;
				Order = new Order(OrderId, customer, orderAddress, shippingAddress, status, paymentMethod, paymentStatus, depositsAmount, restOfMoney, orderDate, orderShipping);
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Order;
	}

	@Override
	public int insert(Order t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO order ("
						
						+ "orderId,"
						+ "customerId,"
						+ "orderAddress,"
						+ "shippingAddress,"
						+ "paymentMethod,"
						
						+ "paymentStatus,"
						+ "depositsAmount,"
						+ "resOfMoney,"
						+ "orderDate,"
						+ "orderShipping,"
						
						+ "status)"
						+ "VALUES(?,?,?,?,?, ?,?,?,?,? ,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getOrderId());
				st.setString(2, t.getCustomer().getCustomerId());
				st.setString(3, t.getAddress());
				st.setString(4, t.getShippingAddress());
				st.setString(5, t.getPaymentMethod());
				st.setString(6, t.getPaymentStatus());
				st.setDouble(7, t.getDepositsAmount());
				st.setDouble(8, t.getRestOfMoney());
				st.setDate(9, t.getOrderDate());
				st.setDate(10, t.getOrderShipping());
				st.setString(11, t.getStatus());

				ketQua = st.executeUpdate();

				System.out.println("Sql: " + sql);
				System.out.println("insert " + ketQua + " dong");

				JDBCUtil.closeConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int inserAll(ArrayList<Order> arr) {
		int count = 0;
		for (Order Order : arr) {

			count += this.insert(Order);

		}
		return count;
	}

	@Override
	public int remove(Order t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "DELETE from order WHERE orderId=?";
				;
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, t.getOrderId());

				ketQua = st.executeUpdate();

				System.out.println("Sql: " + sql);
				System.out.println("del " + ketQua + " dong");

				JDBCUtil.closeConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;

	}

	@Override
	public int removeAll(ArrayList<Order> arr) {
		int count = 0;
		for (Order Order : arr) {

			count += this.remove(Order);

		}
		return count;
	}

	@Override
	public int update(Order t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE order " + "SET" 
					
					
					+ "customerId=?,"
					+ "orderAddress=?,"
					+ "shippingAddress=?,"
					+ "paymentMethod=?,"
					
					+ "paymentStatus=?,"
					+ "depositsAmount=?,"
					+ "resOfMoney=?,"
					+ "orderDate=?,"
					+ "orderShipping=?,"
					
					+ "status=?"+
					" WHERE orderId=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(11, t.getOrderId());
			st.setString(1, t.getCustomer().getCustomerId());
			st.setString(2, t.getAddress());
			st.setString(3, t.getShippingAddress());
			st.setString(4, t.getPaymentMethod());
			st.setString(5, t.getPaymentStatus());
			st.setDouble(6, t.getDepositsAmount());
			st.setDouble(7, t.getRestOfMoney());
			st.setDate(8, t.getOrderDate());
			st.setDate(9, t.getOrderShipping());
			st.setString(10, t.getStatus());
			
			System.out.println("Sql: " + sql);

			ketQua = st.executeUpdate();

			System.out.println("Update " + ketQua + " dong");

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;

	}

	public static void main(String[] args) {
		OrderDAO aut = new OrderDAO();
		ArrayList<Order> kq = new ArrayList<Order>();

		Order newCate = new Order(null, null, null, null, null, null, null, 0, 0, null, null);
		aut.insert(newCate);

		for (Order Order : kq) {
			System.out.println(Order.toString());
		}

	}

}
