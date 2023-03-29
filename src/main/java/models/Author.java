package models;

import java.sql.Date;
import java.util.Objects;

/*
 * - TacGia:
	+ MaTacGia
	+ TenTacGia
	+ NamSinh
	+ TieuSu
	+ thumbnailUrl
 * */
public class Author {
	private String authorId;
	private String fullName;
	private Date birthDay;
	private String description;
	private String thumbnailUrl;

	

	public Author(String authorId, String fullName, Date birthDay, String description, String thumbnailUrl) {
		this.authorId = authorId;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.description = description;
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getthumbnailUrl() {
		return thumbnailUrl;
	}

	public void setthumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId, thumbnailUrl, birthDay, description, fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorId, other.authorId);
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", fullName=" + fullName + ", birthDay=" + birthDay + ", description="
				+ description + ", thumbnailUrl=" + thumbnailUrl + "]";
	}
	

}
