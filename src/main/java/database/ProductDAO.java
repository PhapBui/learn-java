package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Author;
import models.Category;
import models.Product;
import models.Tag;

public class ProductDAO implements DAOInterface<Product> {

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> ProductList = new ArrayList<Product>();

		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Product";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				String authorId = rs.getString("authorId");
				int yearRelease = rs.getInt("yearRelease");
				double priceOriginal = rs.getDouble("priceOriginal");
				double price = rs.getDouble("price");
				double currentPrice = rs.getDouble("currentPrice");
				double quantity = rs.getDouble("quantity");
				String categoryId = rs.getString("categoryId");
				String tagId = rs.getString("tagId");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Author auth = (new AuthorDAO().selectById(new Author(authorId, null, null, null, null)));
				Category cate = (new CategoryDAO().selectById(new Category(categoryId, null, null, null)));
				Tag tag = new TagDAO().selectById(new Tag(tagId, null, null, null));

				Product product = new Product(productId, productName, auth, yearRelease, priceOriginal, price,
						currentPrice, quantity, cate, description, thumbnailUrl, tag);
				ProductList.add(product);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ProductList;
	}

	@Override
	public Product selectById(Product t) {

		Product Product = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Product WHERE ProductId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProductId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				String authorId = rs.getString("authorId");
				int yearRelease = rs.getInt("yearRelease");
				double priceOriginal = rs.getDouble("priceOriginal");
				double price = rs.getDouble("price");
				double currentPrice = rs.getDouble("currentPrice");
				double quantity = rs.getDouble("quantity");
				String categoryId = rs.getString("categoryId");
				String tagId = rs.getString("tagId");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Author auth = (new AuthorDAO().selectById(new Author(authorId, null, null, null, null)));
				Category cate = (new CategoryDAO().selectById(new Category(categoryId, null, null, null)));
				Tag tag = new TagDAO().selectById(new Tag(tagId, null, null, null));

				Product = new Product(productId, productName, auth, yearRelease, priceOriginal, price, currentPrice,
						quantity, cate, description, thumbnailUrl, tag);
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Product;
	}

	@Override
	public int insert(Product t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO Product (" + "productId," + "productName," + "authorId," + "yearRelease,"
						+ "priceOriginal," + "price," + "currentPrice," + "quantity," + "categoryId," + "tagId,"
						+ "description," + "thumbnailUrl)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, t.getProductId());
				st.setString(2, t.getProductName());
				st.setString(3, t.getAuthor().getAuthorId());
				st.setInt(4, t.getYearRelease());
				st.setDouble(5, t.getOriginalPrice());
				st.setDouble(6, t.getPrice());
				st.setDouble(7, t.getCurrentPrice());
				st.setDouble(8, t.getQuantity());
				st.setString(9, t.getCategory().getCategoryId());
				st.setString(10, t.getTag().getTagId());
				st.setString(11, t.getDescription());
				st.setString(12, t.getThumbnailUrl());

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
	public int inserAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product Product : arr) {

			count += this.insert(Product);

		}
		return count;
	}

	@Override
	public int remove(Product t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from Product WHERE ProductId=?";
			;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, t.getProductId());

			ketQua = st.executeUpdate();

			System.out.println("Sql: " + sql);
			System.out.println("del " + ketQua + " dong");

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;

	}

	@Override
	public int removeAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product Product : arr) {
			if (this.selectById(Product) == null) {
				count += this.remove(Product);

			}

		}
		return count;
	}

	@Override
	public int update(Product t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Product " + "SET" + " productName=?," + "authorId=?," + "yearRelease=?,"
					+ "priceOriginal=?," + "price=?," + "currentPrice=?," + "quantity=?," + "categoryId=?," + "tagId=?,"
					+ "description=?," + "thumbnailUrl=?" + " WHERE productId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(12, t.getProductId());
			st.setString(1, t.getProductName());
			st.setString(2, t.getAuthor().getAuthorId());
			st.setInt(3, t.getYearRelease());
			st.setDouble(4, t.getOriginalPrice());
			st.setDouble(5, t.getPrice());
			st.setDouble(6, t.getCurrentPrice());
			st.setDouble(7, t.getQuantity());
			st.setString(8, t.getCategory().getCategoryId());
			st.setString(9, t.getTag().getTagId());
			st.setString(10, t.getDescription());
			st.setString(11, t.getThumbnailUrl());
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
		ProductDAO productDAO = new ProductDAO();

		Author newAuth = new Author("auth01", null, null, null, null);
		Tag newTag = new Tag("cate1", null, null, null);
		Category newCate = new Category("cate1", null, null, null);

		ArrayList<Product> kq = new ArrayList<Product>();
		kq= productDAO.selectAll();
		Product pro = new Product("pr1", "Product 1111", newAuth, 0, 0, 0, 0, 0, newCate, null, null, newTag);
		
		productDAO.insert(pro);

		for (Product product : kq) {
			System.out.println(product.toString());
		}

	}

}
