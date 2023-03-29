package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Author;

public class AuthorDAO implements DAOInterface<Author> {
	private ArrayList<Author> data = new ArrayList<Author>();

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> authorList = new ArrayList<Author>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM author";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String authorId = rs.getString("authorId");
				String fullName = rs.getString("fullName");
				Date birthDay = rs.getDate("birthDay");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Author auth = new Author(authorId, fullName, birthDay, description, thumbnailUrl);
				authorList.add(auth);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return authorList;
	}

	@Override
	public Author selectById(Author t) {

		Author author = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM author WHERE authorId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAuthorId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String authorId = rs.getString("authorId");
				String fullName = rs.getString("fullName");
				Date birthDay = rs.getDate("birthDay");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				author = new Author(authorId, fullName, birthDay, description, thumbnailUrl);
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public int insert(Author t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO author (fullName,birthDay,description,thumbnailUrl,authorId)"
						+ "VALUES(?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getFullName());
				st.setDate(2, t.getBirthDay());
				st.setString(3, t.getDescription());
				st.setString(4, t.getthumbnailUrl());
				st.setString(5, t.getAuthorId());

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
	public int inserAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {

			count += this.insert(author);

		}
		return count;
	}

	@Override
	public int remove(Author t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from author WHERE authorId=?";
			;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, t.getAuthorId());

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
	public int removeAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {
			if (this.selectById(author) == null) {
				count += this.remove(author);

			}

		}
		return count;
	}

	@Override
	public int update(Author t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE author " + "SET" + " fullName=?" + ", birthDay=?" + ", description=?"
					+ ", thumbnailUrl=?" + " WHERE authorId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullName());
			st.setDate(2, t.getBirthDay());
			st.setString(3, t.getDescription());
			st.setString(4, t.getthumbnailUrl());
			st.setString(5, t.getAuthorId());
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
		AuthorDAO aut = new AuthorDAO();
		ArrayList<Author> kq = new ArrayList<Author>();
		for (Author author : kq) {
			
			System.out.println(author.toString());
		}
		Author a =new Author("auth01", null, null, null, null);
		
		Author a1 = aut.selectById(a);
		System.out.println(a1.toString());
		
		Author newAu = new Author("TG2", "Hoa Thien Cot", new Date(2000 - 1900, 3, 5), "chua co", "");
		Author newAu1 = new Author("TG4", "Hoa Cot", new Date(2000 - 1900, 3, 5), "chua co", "");
		Author newAu2 = new Author("TG5", "Hoa Thien ", new Date(2000 - 1900, 3, 5), "chua co", "");

		kq.add(newAu);
		kq.add(newAu1);
		kq.add(newAu2);

		aut.inserAll(kq);
		newAu.setDescription("dem nay bac khong ngu");
		aut.update(newAu);
		aut.remove(newAu);
	}

}
