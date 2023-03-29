package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Tag;

public class TagDAO implements DAOInterface<Tag> {

	@Override
	public ArrayList<Tag> selectAll() {
		ArrayList<Tag> TagList = new ArrayList<Tag>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Tag";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String TagId = rs.getString("TagId");
				String TagName = rs.getString("TagName");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Tag cate = new Tag(TagId, TagName, description, thumbnailUrl);
				TagList.add(cate);
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return TagList;
	}

	@Override
	public Tag selectById(Tag t) {

		Tag Tag = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT*FROM Tag WHERE TagId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTagId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String TagId = rs.getString("TagId");
				String TagName = rs.getString("TagName");
				String description = rs.getString("description");
				String thumbnailUrl = rs.getString("thumbnailUrl");

				Tag = new Tag(TagId, TagName, description, thumbnailUrl);
				break;
			}

			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Tag;
	}

	@Override
	public int insert(Tag t) {
		int ketQua = 0;
		try {
			if (this.selectById(t) == null) {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO Tag (TagId,TagName,description,thumbnailUrl)" + "VALUES(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getTagId());
				st.setString(2, t.getTagName());
				st.setString(3, t.getTagDescription());
				st.setString(4, t.getTagThumbnailUrl());

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
	public int inserAll(ArrayList<Tag> arr) {
		int count = 0;
		for (Tag Tag : arr) {

			count += this.insert(Tag);

		}
		return count;
	}

	@Override
	public int remove(Tag t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from tag WHERE TagId=?";
			;
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, t.getTagId());

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
	public int removeAll(ArrayList<Tag> arr) {
		int count = 0;
		for (Tag Tag : arr) {
			if (this.selectById(Tag) == null) {
				count += this.remove(Tag);

			}

		}
		return count;
	}

	@Override
	public int update(Tag t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Tag " + "SET" + " TagName=?" + ", description=?" + ", thumbnailUrl=?"
					+ " WHERE TagId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(4, t.getTagId());
			st.setString(1, t.getTagName());
			st.setString(2, t.getTagDescription());
			st.setString(3, t.getTagThumbnailUrl());
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
		TagDAO aut = new TagDAO();
		ArrayList<Tag> kq = new ArrayList<Tag>();

		Tag newCate = new Tag("cate1", "Cat Shit", "Cat hot shit", "");
		aut.insert(newCate);

		for (Tag Tag : kq) {
			System.out.println(Tag.toString());
		}

	}

}
