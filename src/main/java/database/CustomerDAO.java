package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Customer;

public class CustomerDAO implements DAOInterface<Customer> {

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Customer";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String address= rs.getString("address");
				String shippingAddress= rs.getString("shippingAddress");
				String orderAddress = rs.getString("orderAddress");
				Date birthday = rs.getDate("birthday");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean subcribe= rs.getBoolean("subcribe");
				String thumbnailUrl= rs.getString("thumbnailUrl");

				Customer customer =new Customer(customerId, username, password, fullName, gender, address, orderAddress, shippingAddress, birthday, phonenumber, email, thumbnailUrl, subcribe) ;
				CustomerList.add(customer);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return CustomerList;
	}

	@Override
	public Customer selectById(Customer t) {

		Customer Customer = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Customer WHERE CustomerId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomerId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				String address= rs.getString("address");
				String shippingAddress= rs.getString("shippingAddress");
				String orderAddress = rs.getString("orderAddress");
				Date birthday = rs.getDate("birthday");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean subcribe= rs.getBoolean("subcribe");
				String thumbnailUrl= rs.getString("thumbnailUrl");

				Customer =new Customer(customerId, username, password, fullName, gender, address, orderAddress, shippingAddress, birthday, phonenumber, email, thumbnailUrl, subcribe) ;
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Customer;
	}

	@Override
	public int insert(Customer t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO Customer ("
						+ "customerId,"
						+ "username,"
						+ "password,"
						+ "gender,"
						+ "address,"
						+ "shippingAddress,"
						+ "orderAddress,"
						+ "birthday,"
						+ "phonenumber,"
						+ "email,"
						+ "subcribe,"
						+ "thumbnailUrl,"
						+ "fullName)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getCustomerId());
				st.setString(2, t.getUsername());
				st.setString(3, t.getPassword());
				st.setString(4, t.getGender());
				st.setString(5, t.getAddress());
				st.setString(6, t.getShippingAddress());
				st.setString(7, t.getOrderAddress());
				st.setDate(8, t.getBirthDay());
				st.setString(9, t.getPhonenumber());
				st.setString(10, t.getEmail());
				st.setBoolean(11, t.isSubcribe());
				st.setString(12, t.getThumbnailUrl());
				st.setString(13, t.getFullName());

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
	public int inserAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer Customer : arr) {

			count += this.insert(Customer);

		}
		return count;
	}

	@Override
	public int remove(Customer t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) != null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "DELETE from customer WHERE customerId=?";
				;
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, t.getCustomerId());

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
	public int removeAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer Customer : arr) {

			count += this.remove(Customer);

		}
		return count;
	}

	@Override
	public int update(Customer t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) != null) {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE customer " + "SET" 
					
					+ " username=?,"
					+ "password=?,"
					+ "gender=?,"
					+ "address=?,"
					+ "shippingAddress=?,"
					+ "orderAddress=?,"
					+ "birthday=?,"
					+ "phonenumber=?,"
					+ "email=?,"
					+ "subcribe=?,"
					+ "thumbnailUrl=?,"
					+ "fullName=?"
					+" WHERE customerId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCustomerId());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(4, t.getGender());
			st.setString(5, t.getAddress());
			st.setString(6, t.getShippingAddress());
			st.setString(7, t.getOrderAddress());
			st.setDate(8, t.getBirthDay());
			st.setString(9, t.getPhonenumber());
			st.setString(10, t.getEmail());
			st.setBoolean(11, t.isSubcribe());
			st.setString(12, t.getThumbnailUrl());
			st.setString(13, t.getFullName());
			System.out.println("Sql: " + sql);

			ketQua = st.executeUpdate();

			System.out.println("Update " + ketQua + " dong");

			JDBCUtil.closeConnection(con);
			}else {
				this.insert(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;

	}

	public static void main(String[] args) {
		CustomerDAO aut = new CustomerDAO();
		ArrayList<Customer> kq = new ArrayList<Customer>();

		Customer newCate = new Customer("cus1", "Customer Pro1", "", "", "", "", "", "", null, "", "", null, false);
		aut.insert(newCate);
		kq = aut.selectAll();
		for (Customer Customer : kq) {
			System.out.println(Customer.toString());
		}

	}

}
