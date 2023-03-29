package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Order;
import models.OrderDetail;
import models.Product;

public class OrderDetailDAO implements DAOInterface<OrderDetail> {

	@Override
	public ArrayList<OrderDetail> selectAll() {
		ArrayList<OrderDetail> OrderDetailList = new ArrayList<OrderDetail>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM OrderDetail";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String OrderDetailId = rs.getString("id");
				String orderId = rs.getString("OrderDetailName");
				String productId = rs.getString("description");
				double quantity = rs.getDouble("thumbnailUrl");
				double originalPrice = rs.getDouble("OrderDetailId");
				
				double price = rs.getDouble("OrderDetailName");
				double currentPrice = rs.getDouble("description");
				double VAT = rs.getDouble("thumbnailUrl");
				double total = rs.getDouble("OrderDetailId");
				
				Order order = new OrderDAO().selectById(new Order(orderId, null, productId, sql, OrderDetailId, orderId, productId, VAT, total, null, null));
				Product product = new ProductDAO().selectById(new Product(productId, productId, null, 0, originalPrice, price, currentPrice, quantity, null, orderId, productId, null));
				
				OrderDetail orderDetail = new OrderDetail(
												OrderDetailId,
												order, 
												product, 
												quantity, 
												originalPrice, 
												price, 
												currentPrice, 
												VAT, 
												total);
				OrderDetailList.add(orderDetail);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return OrderDetailList;
	}

	@Override
	public OrderDetail selectById(OrderDetail t) {

		OrderDetail OrderDetail = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM OrderDetail WHERE OrderDetailId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrderDetailId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String OrderDetailId = rs.getString("id");
				String orderId = rs.getString("OrderDetailName");
				String productId = rs.getString("description");
				double quantity = rs.getDouble("thumbnailUrl");
				double originalPrice = rs.getDouble("OrderDetailId");
				
				double price = rs.getDouble("OrderDetailName");
				double currentPrice = rs.getDouble("description");
				double VAT = rs.getDouble("thumbnailUrl");
				double total = rs.getDouble("OrderDetailId");
				
				Order order = new OrderDAO().selectById(new Order(orderId, null, productId, sql, OrderDetailId, orderId, productId, VAT, total, null, null));
				Product product = new ProductDAO().selectById(new Product(productId, productId, null, 0, originalPrice, price, currentPrice, quantity, null, orderId, productId, null));
				
				OrderDetail = new OrderDetail(
												OrderDetailId,
												order, 
												product, 
												quantity, 
												originalPrice, 
												price, 
												currentPrice, 
												VAT, 
												total);
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return OrderDetail;
	}

	@Override
	public int insert(OrderDetail t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO OrderDetail ("
						+ "id,"
						+ "ordeId,"
						+ "productId,"
						+ "quantity,"
						+ "originalPrice,"
						+ "price,"
						+ "currentPrice,"
						+ "VAT,"
						+ "total)"
						+ "VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getOrderDetailId());
				st.setString(2, t.getOrder().getOrderId());
				st.setString(3, t.getProduct().getProductId());
				st.setDouble(4, t.getQuantity());
				st.setDouble(5, t.getOriginalPrice());
				st.setDouble(6, t.getPrice());
				st.setDouble(7, t.getCurrentPrice());
				st.setDouble(8, t.getVAT());
				st.setDouble(9, t.getTotal());

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
	public int inserAll(ArrayList<OrderDetail> arr) {
		int count = 0;
		for (OrderDetail OrderDetail : arr) {

			count += this.insert(OrderDetail);

		}
		return count;
	}

	@Override
	public int remove(OrderDetail t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "DELETE from OrderDetail WHERE OrderDetailId=?";
				;
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, t.getOrderDetailId());

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
	public int removeAll(ArrayList<OrderDetail> arr) {
		int count = 0;
		for (OrderDetail OrderDetail : arr) {

			count += this.remove(OrderDetail);

		}
		return count;
	}

	@Override
	public int update(OrderDetail t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE OrderDetail " + "SET"  
				
					+ " ordeId=?,"
					+ "productId=?,"
					+ "quantity=?,"
					+ "originalPrice=?,"
					+ "price=?,"
					+ "currentPrice=?,"
					+ "VAT=?,"
					+ "total=?"
					+ " WHERE orderDetailId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(9, t.getOrderDetailId());
			st.setString(1, t.getOrder().getOrderId());
			st.setString(2, t.getProduct().getProductId());
			st.setDouble(3, t.getQuantity());
			st.setDouble(4, t.getOriginalPrice());
			st.setDouble(5, t.getPrice());
			st.setDouble(6, t.getCurrentPrice());
			st.setDouble(7, t.getVAT());
			st.setDouble(8, t.getTotal());
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
		OrderDetailDAO aut = new OrderDetailDAO();
		ArrayList<OrderDetail> kq = new ArrayList<OrderDetail>();

		OrderDetail newCate = new OrderDetail(null, null, null, 0, 0, 0, 0, 0, 0);
		aut.insert(newCate);

		for (OrderDetail OrderDetail : kq) {
			System.out.println(OrderDetail.toString());
		}

	}

}
