package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Category;

public class CategoryDAO implements DAOInterface<Category> {

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> CategoryList = new ArrayList<Category>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM category";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String categoryId = rs.getString("categoryId");
				String categoryName = rs.getString("categoryName");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Category cate = new Category(categoryId, categoryName, description, thumbnailUrl);
				CategoryList.add(cate);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return CategoryList;
	}

	@Override
	public Category selectById(Category t) {

		Category Category = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Category WHERE categoryId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getCategoryId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String categoryId = rs.getString("categoryId");
				String categoryName = rs.getString("categoryName");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Category = new Category(categoryId, categoryName, description, thumbnailUrl);
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Category;
	}

	@Override
	public int insert(Category t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO category (categoryId,categoryName,description,thumbnailUrl)"
						+ "VALUES(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getCategoryId());
				st.setString(2, t.getCategoryName());
				st.setString(3, t.getDescription());
				st.setString(4, t.getThumbnailUrl());

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
	public int inserAll(ArrayList<Category> arr) {
		int count = 0;
		for (Category Category : arr) {

			count += this.insert(Category);

		}
		return count;
	}

	@Override
	public int remove(Category t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "DELETE from category WHERE categoryId=?";
				;
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, t.getCategoryId());

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
	public int removeAll(ArrayList<Category> arr) {
		int count = 0;
		for (Category Category : arr) {

			count += this.remove(Category);

		}
		return count;
	}

	@Override
	public int update(Category t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE category " + "SET" + " categoryName=?" + ", description=?" + ", thumbnailUrl=?"
					+ " WHERE categoryId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(4, t.getCategoryId());
			st.setString(1, t.getCategoryName());
			st.setString(2, t.getDescription());
			st.setString(3, t.getThumbnailUrl());
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
		CategoryDAO aut = new CategoryDAO();
		ArrayList<Category> kq = new ArrayList<Category>();

		Category newCate = new Category("cate1", "Cat Shit", "Cat hot shit", "");
		aut.insert(newCate);

		for (Category category : kq) {
			System.out.println(category.toString());
		}

	}

}
